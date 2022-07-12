package time.modelo;

public class MdlStyle {

    private String _font;
    private int _fontStyle;
    private int _size;
    private int _styleApper;

    public MdlStyle(String font, int fontStyle, int size,int styleApper) {
        this._font = font;
        this._fontStyle = fontStyle;
        this._size = size;
        this._styleApper=styleApper;

    }

    public String getFont() {
        return _font;
    }

    public void setFont(String _font) {
        this._font = _font;
    }

    public int getFontStyle() {
        return _fontStyle;
    }

    public void setFontStyle(int _fontStyle) {
        this._fontStyle = _fontStyle;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int _size) {
        this._size = _size;
    }
   
    public int getStyleApper() {
        return _styleApper;
    }

    public void setStyleApper(int _styleApper) {
        this._styleApper = _styleApper;
    }

    


    @Override
    public String toString() {
        return  _font + "," + _fontStyle + "," + _size+ "," + _styleApper ;
    }
    
    

}
