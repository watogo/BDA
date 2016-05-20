/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Utils.ParseDateToCommonFormat;

/**
 *
 * @author Niklaus
 */
public class ParseDateToCommonFormatTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "{'date_obj': datetime.datetime(2015, 4, 15, 20, 5), 'period': u'day'}";
        ParseDateToCommonFormat test = new ParseDateToCommonFormat();
        test.parseDate(input);
    }

}
