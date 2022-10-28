/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.admin.viewModel;

import infrastructure.constant.KhoHangConstant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Acer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminKhoHangCustom {

    private UUID id;
    private String ma;
    private String ten;
    private KhoHangConstant trangThai;
    private UUID idCoSo;
    private String tenCoSo;

}
