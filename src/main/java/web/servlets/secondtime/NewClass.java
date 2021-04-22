package web.servlets.secondtime;

public class NewClass extends GitTesting{

    int i=0;
    static void print(){
        System.out.println("статическая функция");
    }
    static {
      System.out.println("статический контекст");
    }
    {
     System.out.println("пустой блок в классе без имени" );
        System.out.println(++i + --i);//1 + 0
        System.out.println(++i + i--);//1 + 1
        System.out.println("конец пустого блока без имени");
    }

    public NewClass(int a, boolean b) {
        super(a, b);
    }

    public static void main(String[] args) {
        System.out.println("мэйн");
        System.out.println("___________начало создания объекта_________");
        new NewClass(1,false);
        System.out.println("___________конец создания объекта_________");
        //NewClass git = null;

  }
}

