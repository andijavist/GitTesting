package web.servlets.secondtime;

public class NewClass extends GitTesting{

    int i=0;
    int a=12;

    public NewClass(boolean b) {
        super(b);
    }

    void print(int a){
        System.out.println("функция потомка " + a);
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
        System.out.println("переменная предка а = 2");
        System.out.println("переменная потомка а = 12");
        System.out.println("NewClass child = new NewClass(false)\nchild.a = "+ child.a);
        System.out.println("parent.a (GitTesting parent = child) = " + parent.a + "\n ссылается все равно на поля предка, хоть по ссылке потомок");
        System.out.print("parent.print(parent.a) (GitTesting parent = child) = " );
        parent.print(parent.a);System.out.print("вызывается функция потомка с аргументом предка\n");
        System.out.println("______приколы с наследованием_________");
        //NewClass git = null;

  }
}

