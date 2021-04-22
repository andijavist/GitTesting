package web.servlets.secondtime;

public class NewClass extends GitTesting{

    int i=0;
    int a=12;

    public NewClass(boolean b) {
        super(b);
    }

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
        System.out.println("two"+1/2+(11+1)+"one");
        System.out.println("конец пустого блока без имени!!");
    }




    public static void main(String[] args) {
        System.out.println("мэйн");
        System.out.println("___________начало создания объекта_________");
        NewClass child = new NewClass(false);
        System.out.println("___________конец создания объекта_________");
        GitTesting parent = child;
        System.out.println("______приколы с наследованием_________");
        System.out.println("child.a = "+ child.a);
        System.out.println("parent.a (parent = child) = " + parent.a + " ссылается все равно на парентовские поля, хоть по ссылке потомок");
        //NewClass git = null;

  }
}

