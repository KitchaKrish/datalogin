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
	
	package com.seind.sedps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Role {

	static LinkedHashMap<String, RoleDomain> sdsd = new LinkedHashMap<>();

	public static void main(String[] args) {

		String[] s = { "CEO", "COO", "MGR", "ENG" };
		String[] sss = { "", "CEO", "COO", "MGR" };
		int i = 0;
		for (String ss : s) {
			RoleDomain domain = new RoleDomain();
			List<String> users = new ArrayList<>();
			domain.setRole(ss);
			domain.setReportRole(sss[i]);
			i++;
			sdsd.put(ss, domain);
		}
		System.out.println(sdsd);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User name to Add");
		String userOne = sc.next();
		System.out.println("Enter Role");
		String role = sc.next();
		addNewUser(userOne, role);
		adduser(userOne, role);

		System.out.println(sdsd);

		System.out.println("Enter User name to Add");
		userOne = sc.next();
		System.out.println("Enter Role");
		role = sc.next();
		adduser(userOne, role);
		addNewUser(userOne, role);
		System.out.println(sdsd);
		
		
		System.out.println("Enter User name to Add");
		userOne = sc.next();
		System.out.println("Enter Role");
		role = sc.next();
		adduser(userOne, role);
		addNewUser(userOne, role);
		System.out.println(sdsd);
		
		System.out.println("Enter User name to Add");
		userOne = sc.next();
		System.out.println("Enter Role");
		role = sc.next();
		adduser(userOne, role);
		addNewUser(userOne, role);
		System.out.println(sdsd);
		
		System.out.println("Enter User name to Add");
		userOne = sc.next();
		System.out.println("Enter Role");
		role = sc.next();
		adduser(userOne, role);
		addNewUser(userOne, role);
		System.out.println(sdsd);

		displayUserAndSubUSers();
		
		System.out.println("Enter User One");
		userOne = sc.next();
		System.out.println("Enter User Two");
		role = sc.next();

		findCommonBossOfUser();
		
	}

	private static void findCommonBossOfUser() {
		
		List<String> reverseOrderedKeys = new ArrayList<>(sdsd.keySet());
		Collections.reverse(reverseOrderedKeys);
		System.out.println(reverseOrderedKeys);
		
		for(String list : reverseOrderedKeys) {
			
			RoleDomain domain = sdsd.get(list);
			
			
			
		}
		
	}

	private static void displayUserAndSubUSers() {

		for (String key : sdsd.keySet()) {

			RoleDomain domain = sdsd.get(key);
			List<String> list = domain.getNewUser();
			if (list != null) {
				for (String read : list) {
					String s = "";
					List<String> list2 = domain.getUser();
					if (list2 != null) {
						for (String listeee : list2) {
							s = s + ", " + listeee;
						}
					}
					System.out.println(read + " - " + s);
				}

			}
		}

	}

	private static void addNewUser(String userOne, String role) {
		RoleDomain domain = sdsd.get(role);

		if (domain != null) {

			List<String> users = domain.getNewUser();
			if (users == null) {
				users = new ArrayList<>();
			}

			users.add(userOne);
			domain.setNewUser(users);
			sdsd.put(role, domain);
		}

	}

	private static void adduser(String userOne, String role) {

		RoleDomain domain = sdsd.get(role);

		if (domain != null) {
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

	private static void adduserSecondUser(String userOne, String role) {

		RoleDomain domain = sdsd.get(role);
		if (domain != null) {

			RoleDomain domain1 = sdsd.get(domain.getReportRole());
			if (domain1 != null) {

			} else {
				List<String> users = domain.getUser();
				if (users == null) {
					users = new ArrayList<>();
				}

				if (!role.equalsIgnoreCase(domain.getReportRole())) {

					users.add(userOne);
					domain.setUser(users);
					sdsd.put(role, domain);
				}
			}

		}

	}

}

}
