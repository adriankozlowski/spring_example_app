package pl.sda.store.store.repositories;

import org.springframework.stereotype.Repository;
import pl.sda.store.store.model.Item;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private final List<Item> db = new ArrayList<Item>();

    /**
     * Metoda dodaje dane do naszej bazy danych
     *
     * @param item
     */
    public void add(Item item) {
        db.add(item);
    }

    /**
     * Metoda usuwa dane z naszej bazy dancyh
     *
     * @param item
     */
    public void remove(Item item) {
        db.remove(item);
    }

    /**
     * metoda zwraca wszystkie elementy w naszej bazie
     *
     * @return
     */
    public List<Item> getList() {
        return db;
    }

    /**
     * Wyszukuje indeksu przedmiotu po jego nazwie
     *
     * @param name
     * @return
     */
    public Integer findByName(String name) {
        boolean exists = db.stream().allMatch(i -> i.getName().equals(name));
        if (exists) {
            for (int i = 0; i < db.size(); i++) {
                if (db.get(i).getName().equals(name)) {
                    return i;
                }
            }
        }
        return null;
    }

    public Item get(Integer index) {
        return db.get(index);
    }
}
