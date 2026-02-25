public class Main {
    public static void main(String[] args) {
        PrivateSchoolStudent privateStudent = new PrivateSchoolStudent(101, "Yaseen Abdulghany");
        PublicSchoolStudent publicStudent = new PublicSchoolStudent(115, "Ahmed Omar");

        System.out.println("Private School Student: " + privateStudent.display());
        System.out.println("Public School Student: " + publicStudent.display());
    }
}