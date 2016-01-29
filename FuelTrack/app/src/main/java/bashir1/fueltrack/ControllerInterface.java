package bashir1.fueltrack;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    public void save(Entry entry);
    public void sort();
    public Entry getEntry(Entry entry);
    public Logs getLogs();

/*    + sort(): void
    + viewAll(): void
    + getEntry(Entry: entry): Entry
    + getLogs(): Log*/
}
