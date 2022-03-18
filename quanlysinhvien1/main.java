package quanlysinhvien1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import quanlysinhvien.SortStudentByName;

public class main {
	static List<Student> studentList = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int chose = 0;
		do {
			showMenu();
			chose = Integer.parseInt(scanner.nextLine());
			switch (chose) {
			case 1:
				inputStudent();

				break;
			case 2:
				editStudentById();

				break;
			case 3:
				removeStudentById();

				break;
			case 4:
				sortStudentByGPA();

				break;
			case 5:
				sortStudentByName();

				break;
			case 6:
				displayStudent();

				break;
			case 7:
				saveFile();

				break;
			case 8:
				readFile();

				break;
			case 9:
				System.out.println("thoat!");

				break;

			default:System.out.println("Wrong choise!!! Please enter again");
				break;
			}
		} while (chose != 9);

	}

	private static void sortStudentByName() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	private static void removeStudentById() {
		// TODO Auto-generated method stub
		System.out.println("nhap so student can them :");
		int id = Integer.parseInt(scanner.nextLine());
		for (Student student : studentList) {
			if (student.getId() == id) {
				studentList.remove(student);
				break;
			}
		}

	}

	private static void readFile() {
		// TODO Auto-generated method stub
		System.out.println("doc file student :");
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		try {
			fis=new FileInputStream("student12.txt");
			bis=new BufferedInputStream(fis);
			int i=bis.read();
			StringBuilder line=new StringBuilder();
			
			while (i!=-1) {
				if (((char)i=='\n')||((char)i=='\r')) {
					System.out.println("new line :"+line.toString());
					line.delete(0, line.length());
					i=bis.read();
					continue;
				}
			line.append((char)i);
			i=bis.read();
				}
//			System.out.println("line :"+line.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fis!=null) {
					fis.close();
					bis.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		}
		
	

	

	private static void saveFile() {
		System.out.println("luu file");
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try {
			fos=new FileOutputStream("student12.txt",true);
			bos=new BufferedOutputStream(fos);
			for (Student student : studentList) {
				String line=student.getFileline();
				byte[]a=line.getBytes("utf8");
				
				bos.write(a);
				bos.flush();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fos!=null) {
				try {
					bos.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static void displayStudent() {
		// TODO Auto-generated method stub
		for (Student student : studentList) {
			student.display();
		}

	}

	private static void sortStudentByGPA() {
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if (o1.getGpa() > o2.getGpa()) {
					return -1;
				}
				return 1;
			}

		});

	}

	private static void editStudentById() {
		// TODO Auto-generated method stub
		System.out.println("nhap id student can sua :");
		int id = Integer.parseInt(scanner.nextLine());
		for (Student student : studentList) {
			if (student.getId() == id) {
				student.input();
				break;
			}
		}

	}

	private static void inputStudent() {
		// TODO Auto-generated method stub
		Student student =new Student();
		student.input();
		studentList.add(student);

	}

	// TODO Auto-generated method stub
	static void showMenu() {
		System.out.println("1.them sinh vien.");
		System.out.println("2.sua sinh vien.");
		System.out.println("3.xoa sinh vien.");
		System.out.println("4.săp xep sinh vien theo GPA.");
		System.out.println("5.sắp xếp theo name.");
		System.out.println("6.hien thi.");
		System.out.println("7.luu vao file.");
		System.out.println("8.doc file.");
		System.out.println("9.thoat.");
		System.out.println("--------------------");
		System.out.println("chon");

	}

}
