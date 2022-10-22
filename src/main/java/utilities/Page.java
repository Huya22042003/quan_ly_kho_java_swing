/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author QUOC HUY
 */
public class Page {

    public int next(int offset, int fetch, int pages) {
        offset = offset + fetch;
        if (offset > pages - 1) {
            return offset - fetch;
        }
        return offset;
    }
    
    public int prev(int offset, int fetch) {
        offset = offset - fetch;
        if(offset < 0) {
            return 0;
        }
        return offset;
    }
    
    public int nextIndex(int offset, int fetch, int pages, int index) {
        offset = offset + fetch;
        index = index + 1;
        if (offset > pages - 1) {
            return index - 1;
        }
        return index;
    }
    
        public int prevIndex(int offset, int fetch, int index) {
        offset = offset - fetch;
        index = index - 1;
        if(offset < 0) {
            return 1;
        }
        return index;
    }
}
