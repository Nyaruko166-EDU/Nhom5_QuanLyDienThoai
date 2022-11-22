/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Chip;
import com.fpt.it17326.nhom5.repository.ChipRepository;
import com.fpt.it17326.nhom5.response.ChipResponse;
import com.fpt.it17326.nhom5.service.ChipService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class ChipServiceImpl implements ChipService{

    private ChipRepository chipRepository = new ChipRepository();
    
    @Override
    public List<ChipResponse> getAll() {
        List<Chip> listChip = chipRepository.getAll();
        List<ChipResponse> lst = new ArrayList<>();
        for (Chip x : listChip) {
            ChipResponse chip = new ChipResponse(x);
            lst.add(chip);
        }
        return lst;
    }

    @Override
    public ChipResponse getOne(String MaChip) {
        ChipResponse chip = new ChipResponse(chipRepository.getOne(MaChip));
        return chip;
    }

    @Override
    public String add(Chip chip) {
        if (chipRepository.add(chip)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Chip chip) {
        if (chipRepository.update(chip)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Chip chip) {
        if (chipRepository.delete(chip)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
