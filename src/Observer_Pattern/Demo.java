package Observer_Pattern;

public class Demo {
    public static void main(String[] args) {
        Subject fakeBook = new FakeBook();

        Observer std1 = new Student("Sakib").addSubject(fakeBook);
        Observer std2 = new Student("Tamim").addSubject(fakeBook);
        Observer std3 = new Student("Mushfik").addSubject(fakeBook);
        Observer std4 = new Student("Mahmudullah").addSubject(fakeBook);

        Observer cr = new Captain("Mashrafee").addSubject(fakeBook);
        ((Captain)cr).postMessage("Mahmodollah scored 2 back to back centuries",fakeBook);


    }
}
