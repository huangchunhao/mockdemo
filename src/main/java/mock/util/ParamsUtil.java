package mock.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class ParamsUtil {
    private final static Logger logger = LoggerFactory.getLogger(ParamsUtil.class);
    public static Map<String,String> getParm(HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");//utf-8编码接收
        Map<String,String> rDateArry = new TreeMap<String,String>();

        Enumeration<String> e = request.getParameterNames();
        while(e.hasMoreElements()) {
            String paraStr = e.nextElement();
            if(paraStr != null){
                String value=request.getParameter(paraStr);
                rDateArry.put(paraStr, value);//接收参数,（使用TreeMap自动排序）
            }
        }
        logger.debug("参数："+rDateArry);
        return rDateArry;
    }


    public static Map<String,String> getParm(String Rstr) throws Exception{
        Map<String,String> DateArry = new TreeMap<String,String>();
        String[] ListObj=Rstr.split("&");
        for(String Temp:ListObj){
            if(Temp.matches("(.+?)=(.+?)")){
                String[] TempListObj=Temp.split("=");
                DateArry.put(TempListObj[0], TempListObj[1]);
            }else if(Temp.matches("(.+?)=")){
                String[] TempListObj=Temp.split("=");
                DateArry.put(TempListObj[0],"");
            }else{
                throw new Exception("参数无法分解！");
            }
        }
        return DateArry;
    }
}
