package test.pkj;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.User;
import com.vision.erp.service.user.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class UserTest{

	@Resource(name = "userDAOImpl")
	private UserDAO userDAO;
	
	@Test
	public void testSelectUserList() throws Exception {
		
		Search search = new Search();
		
		List<User> list 
				= (List<User>)userDAO.selectUserList();
		
		for(int i = 0; i<list.size(); i++) {
			User user = list.get(i);
			System.out.println(user);
		}
		
	}

}
