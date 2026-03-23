public class Teacher {
    private Long id; // id > 0
    private String name; // size >=3 and all digits char(a-z)
    private float age; // age >= 25 and age <= 60
    private String phoneNumber; //  +20111390660 13 cher and start with +20
    private float salary;  // salary >= 3000


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id > 0) {
            this.id = id;
        } else id = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean flag = true ;
        for(char ch : name.toCharArray()) {
            if (!(ch >= 'a' && ch <= 'z')) {
                flag = false ;
                break;
            }
        }
        if(!flag || name.length()<3){
            System.out.println("size should be >=3 and all digits char(a-z)");
            return;
        }
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        if(!(age >= 25 && age <= 60)){
            System.out.println("age should be >= 25 and age <= 60");
            return;
        }
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!(phoneNumber.length() == 13 && phoneNumber.startsWith("+20"))){
            System.out.println("phone number length should be 13  and starts with +20");
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if(!(salary >= 3000)){
            System.out.println("salary should be >= 3000");
            return;
        }
        this.salary = salary;
    }
}