package pl.sda.store.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.store.store.model.Item;
import pl.sda.store.store.repositories.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Metoda przekazuje item do repozytorium jeśli nie istnieje taki
     * wpis w bazie. W innym przypadku zmienia stany magazynowe i cenę
     *
     * @param item
     */
    public void addItem(Item item) {
        Integer index = itemRepository.findByName(item.getName());
        if (index != null) {
            Item itemFromRepo = itemRepository.get(index);
            itemFromRepo.setQty(item.getQty());
            itemFromRepo.setPrice(item.getPrice());
        } else {
            itemRepository.add(item);
        }
    }

    /**
     * pobiera całą listę itemów bezpośrednio z repozytorium
     *
     * @return
     */
    public List<Item> getList() {
        return itemRepository.getList();
    }

    public void sell(String name) {
        Integer byName = itemRepository.findByName(name);
        if (byName != null) {
            Item item = itemRepository.get(byName);
            if (item.getQty() == BigDecimal.ONE) {
                itemRepository.remove(item);
            } else {
                item.setQty(item.getQty().subtract(BigDecimal.ONE));
            }
        }
    }
}
