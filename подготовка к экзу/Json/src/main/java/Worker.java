public class Worker
{
    protected int money;
    public int office_hours;
    public String name;
    Worker() {}
    public Worker(String name, int office_hours)
    {
        this.office_hours = office_hours;
        this.money = 0;
        this.name = name;
    }
    public void ShowSalary()
    {
        System.out.println("Зарплата: " + money);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setofficehours(int hours)
    {
        this.office_hours = hours;
    }
}