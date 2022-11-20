/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import domainModels.NhaCungCap;
import infrastructures.constant.NhaCungCapConstant;
import infrastructures.constant.CoSoConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhoHangConstant;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiPhieuConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;

/**
 *
 * @author QUOC HUY
 */
public class Converter {

    public static String trangThaiDonHang(TrangThaiPhieuConstant th) {
        String trangThai = "";

        switch (th) {
            case CHO_THANH_TOAN:
                trangThai = "Chờ thanh toán";
                break;
            case DA_HUY:
                trangThai = "Đã hủy";
                break;
            case DA_THANH_TOAN:
                trangThai = "Đang thanh toán";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String trangThaiNhanVien(TrangThaiNhanVienConstant th) {
        String trangThai = "";

        switch (th) {
            case CHUA_HOAT_DONG:
                trangThai = "Chưa hoạt động";
                break;
            case DANG_HOAT_DONG:
                trangThai = "Đang hoạt động";
                break;
            case DA_NGHI_VIEC:
                trangThai = "Đã nghỉ việc";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String trangThaiGioiTinh(GioiTinhConstant th) {
        String trangThai = "";
        switch (th) {
            case KHAC:
                trangThai = "Khác";
                break;
            case NAM:
                trangThai = "Nam";
                break;
            case NU:
                trangThai = "Nữ";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String trangThaiKhoHang(KhoHangConstant th) {
        String trangThai = "";

        switch (th) {
            case DANG_HOAT_DONG:
                trangThai = "Đang hoạt động";
                break;
            case DA_DONG_CUA:
                trangThai = "Đã hoạt động";
                break;
            case SAP_HOAT_DONG:
                trangThai = "Sắp hoạt động";
                break;
            case TAM_NGHI:
                trangThai = "Tạm nghỉ";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String trangThaiCoSo(CoSoConstant th) {
        String trangThai = "";

        switch (th) {
            case DANG_HOAT_DONG:
                trangThai = "Đang hoạt động";
                break;
            case DA_DONG_CUA:
                trangThai = "Đã hoạt động";
                break;
            case SAP_HOAT_DONG:
                trangThai = "Sắp hoạt động";
                break;
            case TAM_NGHI:
                trangThai = "Tạm nghỉ";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String trangThaiNhaCungCap(NhaCungCapConstant th) {
        String trangThai = "";
        switch (th) {
            case DANG_SU_DUNG:
                trangThai = "Đang sử dụng";
                break;
            case KHONG_SU_DUNG:
                trangThai = "Không sử dụng";
                break;
            default:
                throw new AssertionError();
        }

        return trangThai;
    }

    public static String TrangThaiPhieuXuat(TrangThaiPhieuConstant p) {
        String trangThai = "";
        switch (p) {
            case CHO_THANH_TOAN:
                trangThai = "Chờ Thanh Toán";
                break;
            case DA_HUY:
                trangThai = "Đã Hủy";
                break;
            case DA_THANH_TOAN:
                trangThai = "Đã Thanh Toán";
                break;
            default:
                throw new AssertionError();
        }
        
        return trangThai;
    }
    
}
