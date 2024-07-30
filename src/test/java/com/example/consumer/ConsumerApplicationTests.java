package com.example.consumer;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.consumer.dto.EmployeeDTO;
import com.example.consumer.entity.City;
import com.example.consumer.entity.Employee;
import com.example.consumer.entity.EmployeeVal;
import com.example.consumer.entity.User;
import com.example.consumer.mapper.CityMapper;
import com.example.consumer.mapper.EmployeeMapper;
import com.example.consumer.mapper.EmployeeValMapper;
import com.example.consumer.mapper.UserMapper;
import com.example.consumer.service.EmployeeService;
import com.example.consumer.service.ICityService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConsumerApplicationTests {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ICityService cityService;

	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private EmployeeValMapper employeeValMapper;

	// 查询
	@Test
	void contextLoads() {
		List<Employee> employeeList = employeeMapper.selectList(null);
		employeeList.forEach(System.out::println);
	}

	// 查询
	@Test
	void contextLoadsCity() {
		List<City> cityList = cityMapper.selectList(null);
		cityList.forEach(System.out::println);
	}

	@Test
	public void testSelectById() {
		Employee employee=employeeMapper.selectById(1813174472148275202L);
		System.out.println(employee);
	}

	@Test
	public void testSelectBatchIds() {
		List<Long> list= Arrays.asList(1813174472148275202L,1813167730379280385L,1367717669156028418L);
		List<Employee> employeeList = employeeMapper.selectBatchIds(list);
		employeeList.forEach(System.out::println);
	}

	@Test
	public void testSelectByMap() {
		Map<String,Object> map=new HashMap<>();
		map.put("emp_gender","男");
		map.put("age",18);
		List<Employee> employeeList = employeeMapper.selectByMap(map);
		employeeList.forEach(System.out::println);
	}

	@Test
	public void testdateByName(){
		//根据员工的名字,更新
		Employee employee2=new Employee();
		employee2.setEmpGender("男");
		employee2.setAge(18);
		employee2.setEmail("liulong@126.com");
		employeeMapper.update(employee2,new UpdateWrapper<Employee>().eq("name","刘龙"));
	}

	//查询姓名为张春雨并且性别为男的员工
	@Test
	public void testSelectOne(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("name","张春雨");
		queryWrapper.eq("emp_gender","男");
		Employee employee = employeeMapper.selectOne(queryWrapper);
		System.out.println(employee);
	}

	//查询姓名中带有"磊"的并且年龄小于30的员工
	@Test
	public void testSelectList(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.like("name","磊").lt("age",30);
		List<Employee> employeeList = employeeMapper.selectList(queryWrapper);
		employeeList.forEach(System.out::println);
	}

	//查询姓刘的或者性别为男，按年龄的除序排序
	@Test
	public void testSelectList2(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.like("name","王")
				.or().eq("emp_gender","男")
				.orderByDesc("age");
		List<Employee> employeeList = employeeMapper.selectList(queryWrapper);
		employeeList.forEach(System.out::println);
	}

	//查询姓刘的并且（年龄小于35或者邮箱不为空）
	@Test
	public void testSelectList3(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.likeRight("name","刘")
				.and(wq->wq.lt("age",35).or().isNotNull("email"));
		List<Employee> employeeList = employeeMapper.selectList(queryWrapper);
		employeeList.forEach(System.out::println);
	}

	// 组合条件查询
	@Test
	void queryUser1() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.and((i)->{
			i.gt("age",20).like("name","o");
		}).or((i)->{
			i.isNotNull("email");
		});
		List<User> users = userMapper.selectList(wrapper);
		users.forEach(System.out::println);
	}

	/**
	 * 子查询
	 * SELECT uid,name,age,email,is_deleted
	 * FROM t_user
	 * WHERE (
	 *          uid IN (select uid from t_user where uid < 5)
	 *      )
	 */
	@Test
	void queryUser() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.inSql("id","select id from user where id < 5");
		List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
		maps.forEach(System.out::println);
	}



	@Test
	public void testSelectPage(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.lt("age",50);
		Page<Employee> page=new Page<>(1,2);
		Page<Employee> employeePage = employeeMapper.selectPage(page, queryWrapper);
		System.out.println("当前页:"+ employeePage.getCurrent());
		System.out.println("每页记录数:"+employeePage.getSize());
		System.out.println("总记录数:"+employeePage.getTotal());
		System.out.println("总页数:"+employeePage.getPages());
		List<Employee> employeeList = employeePage.getRecords();
		employeeList.forEach(System.out::println);
	}

	// 插入
	@Test
	void testInsert() {
		Employee employee = new Employee();
		employee.setName("刘龙");
		employee.setEmpGender("男");
		employee.setAge(25);
		employee.setEmail("liulong@163.com");
		employeeMapper.insert(employee);
	}

	@Test
	public void testInsert2() {
		Employee employee=new Employee();
		employee.setName("刘龙200");
		employee.setEmpGender("男");
		employee.setAge(25);
		employee.setEmail("liulong@163.com");
		employee.setRemark("该员工是一个好员工");
		employeeMapper.insert(employee);
		System.out.println(employee.getEmpId());
	}


	@Test
	public void testSave(){
		Employee employee=new Employee();
		employee.setName("孙宝来");
		employee.setEmpGender("男");
		employee.setAge(30);
		employee.setEmail("sunbaolai@qq.com");
		employeeService.save(employee);
	}

	@Test
	public void testSaveOrUpdate(){
		Employee employee=new Employee();
		employee.setEmpId(1367720249630318594L);
		employee.setName("孙宝来");
		employee.setEmpGender("女");
		employee.setAge(33);
		employee.setEmail("sunbaolai@qq.com");
		employeeService.saveOrUpdate(employee);
	}

	@Test
	public void testGetOne(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.gt("age",24);
		Employee employee = employeeService.getOne(queryWrapper,false);
		System.out.println(employee);
	}



	@Test
	public void testGetList(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.gt("age",24);
		List<Employee> employeeList = employeeService.list(queryWrapper);
		for(Employee e : employeeList) {
			QueryWrapper<EmployeeVal> q2 = new QueryWrapper<>();
			q2.gt("emp_id",e.getEmpId());
			List<EmployeeVal> employeeValList = employeeValMapper.selectList(q2);
			e.setEmployeeValList(employeeValList);
		}



		employeeList.forEach(System.out::println);

		List<EmployeeDTO> dtoList = BeanUtil.copyToList(employeeList, EmployeeDTO.class);

		dtoList.forEach(System.out::println);

	}

	@Test
	public void testGetCityList(){
		QueryWrapper<City> queryWrapper=new QueryWrapper<>();
		List<City> cityList = cityService.list(queryWrapper);
		cityList.forEach(System.out::println);
	}

	@Test
	public void testGetCityListLimit10(){

		QueryWrapper<City> queryWrapper=new QueryWrapper<>();
		queryWrapper.lt("id", 10);
		List<City> data = cityService.list(queryWrapper);
		data.forEach(System.out::println);
	}

	// 动态sql 1 ; 代码逻辑判断，初级
	@Test
	void queryTrendsUser1() {
		String  name = "Tom";
		Integer age = null;
		String email = null;
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		if(!StringUtils.isEmpty(name)){
			wrapper.eq("name",name);
		}
		if(age != null && age > 0){
			wrapper.eq("age",age);
		}
		if(!StringUtils.isEmpty(email)){
			wrapper.eq("email",email);
		}
		List<User> users = userMapper.selectList(wrapper);
		users.forEach(System.out::println);
	}

	// 动态sql 2, Condition 参数实现动态
	@Test
	void queryTrendsUser2() {
		String  name = "Tom";
		Integer age = null;
		String email = null;
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq(!StringUtils.isEmpty(name),"name",name)
				.eq(age!=null && age > 0 ,"age" ,age)
				.eq(!StringUtils.isEmpty(email),"email",email);
		List<User> users = userMapper.selectList(wrapper);
		users.forEach(System.out::println);
	}



	@Test
	void testInsert3() {
		User user = new User();
		userMapper.insert(user);
		assertThat(user.getId()).isNotNull();
	}


	// 更新
	@Test
	public void testUpdateById() {
		Employee employee=new Employee();
		employee.setEmpId(10L);
		employee.setName("刘龙");
		employee.setEmpGender("女");
		employee.setAge(23);
		employee.setEmail("liulong@163.com");
		employeeMapper.updateById(employee);
	}

	//根据姓名和年龄修改记录
	@Test
	public void testUpdate(){
		QueryWrapper<Employee> updateWrapper=new QueryWrapper<>();
		updateWrapper.eq("name","刘龙")
				.eq("age",25);
		Employee employee=new Employee();
//		employee.setEmpId(8L);
		employee.setName("王三2");
//		employee.setEmail("zhanglei@163.com");
//		employee.setAge(33);
//		employee.setEmpGender("男");
		int rows=employeeMapper.update(employee, updateWrapper);
		System.out.println("受影响的行数:"+rows);
	}

	/**
	 * 更新用户Tom的age和邮箱信息
	 * UPDATE t_user SET age=?,email=? WHERE (name = ?)
	 */
	@Test
	void updateUser() {
		UpdateWrapper<User> wrapper = new UpdateWrapper<>();
		wrapper.set("age",25)
				.set("email","bobo@qq.com")
				.eq("name","Tom");
		int update = userMapper.update(null, wrapper);
		System.out.println("update = " + update);
	}


	// 删除
	@Test
	public void testDeleteById(){
		int rows=employeeMapper.deleteById(1813174472148275202L);
		System.out.println("受影响的行数:"+rows);
	}

	@Test
	public void testDeleteByMap(){
		Map<String,Object> map=new HashMap<>();
		map.put("emp_gender","男");
		map.put("name","何雨柱");
		int rows=employeeMapper.deleteByMap(map);
		System.out.println("受影响的行数:"+rows);
	}

	@Test
	public void testDeleteBatchIds(){
		List<Long> list= Arrays.asList(4L,7L,1L);
		int rows=employeeMapper.deleteBatchIds(list);
		System.out.println("受影响的行数:"+rows);
	}

	//根据姓名和年龄删除记录
	@Test
	public void testDelete(){
		QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("name","刘龙")
				.eq("age",26);
		int rows=employeeMapper.delete(queryWrapper);
		System.out.println("受影响的行数:"+rows);
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(" ---- selectAll method ----");
		List<User> userList = userMapper.selectList(null);
		Assert.isTrue(5 == userList.size(), "");
		userList.forEach(System.out::println);
	}
}
