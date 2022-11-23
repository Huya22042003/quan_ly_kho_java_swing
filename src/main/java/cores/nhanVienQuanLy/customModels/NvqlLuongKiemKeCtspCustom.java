/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import infrastructures.constant.MauConstant;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author window
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NvqlLuongKiemKeCtspCustom {
    private UUID id;
    private String ma;
    private String ten;
    private int soLuongTon;
    private String donVi;
    private MauConstant mau;
    private String namBaoHanh;
    private BigDecimal giaBan;
}
