package com.mellsvs.hotel_room.model;

import com.mellsvs.hotel_room.model.enums.HouseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data


public class House {
    private Long id ;
    private double metrekare;
    private int odaSayisi;
    private int salonSayisi;
    private double fiyat;
    private HouseType houseType;

    public House() {
    }

    public House(Long id, double metrekare, int odaSayisi, int salonSayisi, double fiyat, HouseType houseType) {
        this.id = id;
        this.metrekare = metrekare;
        this.odaSayisi = odaSayisi;
        this.salonSayisi = salonSayisi;
        this.fiyat = fiyat;
        this.houseType = houseType;
    }
}
