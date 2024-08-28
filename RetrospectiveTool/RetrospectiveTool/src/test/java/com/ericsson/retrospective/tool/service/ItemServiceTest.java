package com.ericsson.retrospective.tool.service;

import com.ericsson.retrospective.tool.dtos.ItemDto;
import com.ericsson.retrospective.tool.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test()
    void invalid_name_addItem() {
        ItemDto item = new ItemDto("");

        try {

            itemService.save(item);
            fail();
        } catch(IllegalArgumentException ex) {
            assertEquals("Name cannot be empty.", ex.getMessage());
        }
    }

    @Test()
    void valid_name_addItems() {
        ItemDto item = new ItemDto("Name");
        ItemDto i = itemService.save(item);

        assertEquals(item.getName(), i.getName());
    }

    @Test
    void empty_findAllItems() {
        assertThat(itemRepository.findAll().isEmpty()).isTrue();
    }

    @Test
    void invalid_findItem() {
        ItemDto item = new ItemDto("Test");
        ItemDto result = itemService.save(item);
        int invalidId = result.getId() * 2;

        try {
            itemService.getById(invalidId);
            fail();
        } catch (NullPointerException exception) {
            assertEquals(new NullPointerException().getMessage(), exception.getMessage());
        }
    }
}
