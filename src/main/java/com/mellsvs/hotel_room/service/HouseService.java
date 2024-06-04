package com.mellsvs.hotel_room.service;

import com.mellsvs.hotel_room.model.House;
import com.mellsvs.hotel_room.model.enums.HouseType;
import com.mellsvs.hotel_room.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getEvList() {
        return houseRepository.findByHouseType(HouseType.EV);
    }

    public List<House> getVillaList() {
        return houseRepository.findByHouseType(HouseType.VILLA);
    }

    public List<House> getYazlikList() {
        return houseRepository.findByHouseType(HouseType.YAZLIK);
    }

    public double toplamEvFiyati() {
        return getEvList().stream().mapToDouble(House::getFiyat).sum();
    }

    public double toplamVillaFiyati() {
        return getVillaList().stream().mapToDouble(House::getFiyat).sum();
    }

    public double toplamYazlikFiyati() {
        return getYazlikList().stream().mapToDouble(House::getFiyat).sum();
    }

    public double toplamTumEvFiyati() {
        return toplamEvFiyati() + toplamVillaFiyati() + toplamYazlikFiyati();
    }

    public double ortalamaEvMetrekare() {
        return getEvList().stream().mapToDouble(House::getMetrekare).average().orElse(0);
    }

    public double ortalamaVillaMetrekare() {
        return getVillaList().stream().mapToDouble(House::getMetrekare).average().orElse(0);
    }

    public double ortalamaYazlikMetrekare() {
        return getYazlikList().stream().mapToDouble(House::getMetrekare).average().orElse(0);
    }

    public double ortalamaTumEvMetrekare() {
        List<House> tumEvler = houseRepository.findAll();
        return tumEvler.stream().mapToDouble(House::getMetrekare).average().orElse(0);
    }

    public List<House> odaVeSalonFiltrele(int odaSayisi, int salonSayisi) {
        return houseRepository.findByOdaSayisiAndSalonSayisi(odaSayisi, salonSayisi);
    }
}
