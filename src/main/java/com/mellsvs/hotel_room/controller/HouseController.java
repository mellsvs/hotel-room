package com.mellsvs.hotel_room.controller;

import com.mellsvs.hotel_room.model.House;
import com.mellsvs.hotel_room.service.HouseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@Tag(name = "House", description = "House Controller ile end point testi")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/evler")
    public List<House> getEvList() {
        return houseService.getEvList();
    }

    @GetMapping("/villalar")
    public List<House> getVillaList() {
        return houseService.getVillaList();
    }

    @GetMapping("/yazliklar")
    public List<House> getYazlikList() {
        return houseService.getYazlikList();
    }

    @GetMapping("/toplam-ev-fiyati")
    public double toplamEvFiyati() {
        return houseService.toplamEvFiyati();
    }

    @GetMapping("/toplam-villa-fiyati")
    public double toplamVillaFiyati() {
        return houseService.toplamVillaFiyati();
    }

    @GetMapping("/toplam-yazlik-fiyati")
    public double toplamYazlikFiyati() {
        return houseService.toplamYazlikFiyati();
    }

    @GetMapping("/toplam-tum-ev-fiyati")
    public double toplamTumEvFiyati() {
        return houseService.toplamTumEvFiyati();
    }

    @GetMapping("/ortalama-ev-metrekare")
    public double ortalamaEvMetrekare() {
        return houseService.ortalamaEvMetrekare();
    }

    @GetMapping("/ortalama-villa-metrekare")
    public double ortalamaVillaMetrekare() {
        return houseService.ortalamaVillaMetrekare();
    }

    @GetMapping("/ortalama-yazlik-metrekare")
    public double ortalamaYazlikMetrekare() {
        return houseService.ortalamaYazlikMetrekare();
    }

    @GetMapping("/ortalama-tum-ev-metrekare")
    public double ortalamaTumEvMetrekare() {
        return houseService.ortalamaTumEvMetrekare();
    }

    @GetMapping("/filtrele/{odaSayisi}/{salonSayisi}")
    public List<House> odaVeSalonFiltrele(@PathVariable int odaSayisi, @PathVariable int salonSayisi) {
        return houseService.odaVeSalonFiltrele(odaSayisi, salonSayisi);
    }
}
