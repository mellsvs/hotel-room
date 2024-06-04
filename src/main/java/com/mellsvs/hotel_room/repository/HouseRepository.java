package com.mellsvs.hotel_room.repository;

import com.mellsvs.hotel_room.model.House;
import com.mellsvs.hotel_room.model.enums.HouseType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HouseRepository {
    private List<House> houses = new ArrayList<>();

    public HouseRepository() {
        // Örnek veriler ekleniyor
        houses.add(new House(1L, 120, 3, 1, 300000, HouseType.EV));
        houses.add(new House(2L, 140, 4, 1, 350000, HouseType.EV));
        houses.add(new House(3L, 100, 2, 1, 250000, HouseType.EV));
        houses.add(new House(4L, 300, 5, 2, 1000000, HouseType.VILLA));
        houses.add(new House(5L, 350, 6, 2, 1200000, HouseType.VILLA));
        houses.add(new House(6L, 280, 4, 2, 900000, HouseType.VILLA));
        houses.add(new House(7L, 150, 3, 1, 600000, HouseType.YAZLIK));
        houses.add(new House(8L, 180, 4, 1, 750000, HouseType.YAZLIK));
        houses.add(new House(9L, 130, 2, 1, 500000, HouseType.YAZLIK));
    }

    public List<House> findAll() {
        return houses;
    }

    public List<House> findByHouseType(HouseType houseType) {
        return houses.stream()
                .filter(house -> house.getHouseType() == houseType)
                .collect(Collectors.toList());
    }

    public List<House> findByOdaSayisiAndSalonSayisi(int odaSayisi, int salonSayisi) {
        return houses.stream()
                .filter(house -> house.getOdaSayisi() == odaSayisi && house.getSalonSayisi() == salonSayisi)
                .collect(Collectors.toList());
    }
}
