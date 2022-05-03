package com.datalogin.datalogin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataloginApplicationTests {

    @Test
    public void contextLoads() {
    }
private static void adduser(String userOne, String role) {
		
		RoleDomain domain = sdsd.get(role);

		if (domain!=null) {
			RoleDomain domain1 = sdsd.get(domain.getReportRole());

			if (domain1 != null) {
				List<String> users = domain1.getUser();
				if (users == null) {
					users = new ArrayList<>();
				}

				if (!role.equalsIgnoreCase(domain1.getReportRole())) {

					users.add(userOne);
					domain1.setUser(users);
					sdsd.put(role, domain);
					adduser(userOne, domain.getReportRole());
				}
			}

		}

	}
	
}
