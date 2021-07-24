package trainingTask3.p4;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public static void main(String[] args){
        String[] shirts = new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
        Shirt[] realShirts = new Shirt[11];
        for (int i=0; i<11; i++){
            realShirts[i]=new Shirt();
            realShirts[i].initShirt(shirts[i]);
            System.out.println(realShirts[i].toString());
        }
    }

    public void initShirt(String str){
        String[] words = str.split(",");
        id = words[0].trim();
        description = words[1].trim();
        color = words[2].trim();
        size = words[3].trim();
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
