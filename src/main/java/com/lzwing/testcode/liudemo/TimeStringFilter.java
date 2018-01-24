package com.lzwing.testcode.liudemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/1/24
 * Time: 11:36
 */
public class TimeStringFilter {
    public static void main(String[] args) {
        String before = "INSERT INTO ehr_arch_basicinfo (basicinfoid,archiveid,fullname,gender,birthday,identityno,img,resaddr_committee,resaddr_doorno,curaddr_committee,curaddr_doorno,company,tel,linkman,linkman_tel,residenttype,nation,bloodgroup,bloodrh,education,vocation,marriage,paytype,paytype_other,hypersuses,hypersuses_other,undress,undress_other,dishyperflag,disdmflag,disheartflag,dislungflag,distumorflag,disstrokeflag,dismentalflag,distbflag,dishepatitisflag,disinfectflag,disoccupationflag,has_inherit_dis,inherit_dis,deformity,deformity_other,familyid,relationship,medicareid,archstatus,password,dutydoctor,build_date,builddoctor,remark,duns,status,created_by,created_date,updated_by,updated_date,disabled_by,disabled_date,hasfamilylist,hasops,hyperdiagnosedate,dmdiagnosedate,heartdiagnosedate,lungdiagnosedate,tumordiagnosedate,tumorname,strokediagnosedate,mentadiagnosedate,tbdiagnosedate,hepatitdiagnosedate,infectdiagnosedate,occupadiagnosedate,occupationname,disotherflag,disothername,disotherdiagnosedate,archiveno,healthno,idcardia,idcarddatestart,idcarddateend,datasrc,ispoor) values ('201712306103220000526','61032219620218481X','仝新明','GB_T_2261.1_2003_1','1962-02-1800:00:00','61032219620218481X',null,'610322110213','一组39','610322110213','一组','尧典村',null,null,'15292954524','1','GB_3304_1991_1','CV5103.02_5',null,'GB_4658_2006_80','SX0185_5','GB_T_2261.2_2003_20','SX0074_3|SX0074_5',null,'SX0076_1',null,'CV5101.04_1',null,'2','2','1','2','2','2','2','2','2','2','2','SX0087_2',null,'SX0077_1',null,'201712306103220000090','CV0218.01_01',null,'SX0100_1','14e1b600b1fd579f47433b88e8d85291','610322198210124218','2017-12-3017:05:48','610322198210124218',null,'610322PDY700618',1,'董晓晖','2017-12-3017:05:48','董晓晖','2017-12-3017:05:48',null,null,'SX0087_2','SX0087_2',null,null,'2015-11-1700:00:00',null,null,null,null,null,null,null,null,null,null,'2',null,null,null,null,null,null,null,'SX0374_1',null)";

        System.out.println("before:"+before);

        String after = illegalFilter(before);

        System.out.println("after:"+after);
    }

    public static String illegalFilter(String origin) {
        if (origin == null || origin.length() <= 0) {
            return origin;
        }

        Pattern p = Pattern.compile("([0-9]{4}-[0-9]{2})-([0-9]{2})([0-9]{2}):([0-9]{2}:[0-9]{2})");

        Matcher matcher = p.matcher(origin);

        while(matcher.find()) {
            String correctStr = String.format("%s-%s %s:%s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
            origin = origin.replaceAll(matcher.group(0), correctStr);
        }
        return origin;
    }
}
