/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilit;

import infrastructure.constant.CoSoConstant;
import infrastructure.constant.GioiTinhConstant;
import infrastructure.constant.KhoHangConstant;
import infrastructure.constant.TrangThaiDonHangConstant;
import infrastructure.constant.TrangThaiNhanVienConstant;

/**
 *
 * @author QUOC HUY
 */
public class Coverter {

    public static String trangThaiDonHang(TrangThaiDonHangConstant th) {
        String trangThai = "";

        switch (th) {
            case CHO_XAC_NHAN:
                trangThai = "Chờ xác nhận";
                break;
            case DANG_XU_LY:
                trangThai = "Đang xử lý";
                break;
            case DANG_GIAO:
                trangThai = "Đang giao";
                break;
            case DA_DEN_NOI:
                trangThai = "Đã đến nơi";
                break;
            case GIAO_THANH_CONG:
                trangThai = "Giao hàng thành công";
                break;
            case HOAN_DON:
                trangThai = "Đang hoàn đơn";
                break;
            case HUY_DON:
                trangThai = "Hủy đơn";
                break;
            case THANH_LY:
                trangThai = "Thanh lý";
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
}
