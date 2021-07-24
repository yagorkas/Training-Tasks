package trainingTask3.p1;

public class MainClass{
    public static void main(String[] args){
        System.out.println(InstructionsSQL.getInstruction("Group1", 3));
    }
}

class InstructionsSQL{
    static String getInstruction(String group,int dolg){
        String instruction = new String();

        instruction = "INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) " +
                "SELECT id_Student, firstName, lastName, id_Group FROM T_Student " +
                "WHERE id_Group = '" + group + "' AND dolgCount > "+ dolg;
        return instruction;
    }

}
