package com.song.common.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 *
 * Excel 工具类
 * @author shizuku
 * @date 2019/8/24 14:14
 */
public class ExcelUtils {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 2003 后缀,暂不支持
     */
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    /**
     * 2010 后缀
     */
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    /**
     * Excel 表 Cell 赋值
     * @param cell
     * @param value
     */
    public static void addCellValue(Cell cell,Object value){
        if(value == null){
            cell.setCellValue("");
        }
        else{
            if(value instanceof Integer){
                cell.setCellValue((Integer)value);
            }else if(value instanceof Double){
                cell.setCellValue((Double) value);
            }
            else if(value instanceof  Float){
                cell.setCellValue((Float)value);
            }
            else if(value instanceof Date){
                cell.setCellValue((Date)value);
            }
            else if(value instanceof  String){
                cell.setCellValue((String)value);
            }
            else if(value instanceof Calendar){
                cell.setCellValue((Calendar) value);
            }
            else if(value instanceof BigDecimal){
                cell.setCellValue(((BigDecimal) value).doubleValue());
            }
            else{
                cell.setCellValue("");
            }
        }
    }


    /**
     * 根据文件和流获取WorkBook 对象
     * @param fileName
     * @param is
     * @return
     * @throws IOException
     */
    public static Workbook readFromInputStream(String fileName, InputStream is) throws IOException {
        if(StringUtils.isEmpty(fileName) || is == null){
            return null;
        }
        Workbook workbook = null;
        if(isExcel2007(fileName)){
            workbook = new XSSFWorkbook(is);
        }else{
            workbook = new HSSFWorkbook(is);
        }
        return workbook;
    }

    /**
     * 判断是否为2007 的Excel 格式
     * @param fileName
     * @return
     */
    public static boolean isExcel2007(String fileName){
        if(StringUtils.isEmpty(fileName)){
            return false;
        }
        String filePostFix = FileUtils.getFilePostFix(fileName);
        if(filePostFix.equals(OFFICE_EXCEL_2010_POSTFIX)){
            return true;
        }
        else{
            return false;
        }
    }




    /**
     * 下载 Excel 文件
     * @param fileName
     * @param workbook
     * @param response
     */
    public static void downloadExcelFile(String fileName, Workbook workbook, HttpServletResponse response){
        if(StringUtils.isEmpty(fileName)){
            fileName = UUID.randomUUID().toString() + "." +OFFICE_EXCEL_2010_POSTFIX;
        }
        if(workbook == null || response == null){
            return ;
        }
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO8859-1"));
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Accept-Ranges", "bytes");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            workbook.write(os);
        } catch (IOException e) {
            logger.warn("downloadExcelFile",e);
        }
        finally{
            if(os != null){
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    logger.warn("downloadExcelFile",e);
                }
            }
        }
    }
}
