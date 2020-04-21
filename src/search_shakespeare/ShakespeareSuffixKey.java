package search_shakespeare;

/**
 *
 * @author stanislavnovitski
 */
public class ShakespeareSuffixKey implements Key<ShakespeareSuffixKey> {

    private final int max = 'z' - 'a' + 3;
    private final int length;
    private String text;
    private int origin = 0;
    private int position = 0;

    public ShakespeareSuffixKey(String text, int origin, int position) {
        this.text = text;
        this.origin = origin;
        this.position = position;
        this.length = text.length() - position;
    }

    public ShakespeareSuffixKey(String text) {
        this.text = text;
        this.length = text.length() - this.position;
    }

    private int indexOf(int position) {
        if (position >= this.text.length()) {
            return 0;
        }

        char charAtPos = this.text.charAt(position);

        if (charAtPos == ' ') {
            return 1;
        } else if (charAtPos >= 'a' && charAtPos <= 'z') {
            return charAtPos - 'a' + 2;
        } else if (charAtPos >= 'A' && charAtPos <= 'Z') {
            return charAtPos - 'A' + 2;
        }
        return max;
    }

    public int getIndex() {
        return indexOf(this.position);
    }

    public int getLength() {
        return this.length;
    }

    public int getSize() {
        return this.text.length() - this.origin;
    }

    public int getOrigin() {
        return this.origin;
    }

    public String getText() {
        return text;
    }

    public int getPosition() {
        return position;
    }

    public int getMax() {
        return this.max;
    }

    public ShakespeareSuffixKey getNext() {
        return new ShakespeareSuffixKey(this.text, this.origin, this.position + 1);
    }

    public ShakespeareSuffixKey getRest() {
        return new ShakespeareSuffixKey(this.text, this.origin + 1, this.origin + 1);
    }

    @Override
    public boolean includes(ShakespeareSuffixKey other) {
        boolean go = false;
        if ((other.getClass().equals(this.getClass())) && (other.getSize() <= this.getSize())) {

            int l = other.getText().length() - other.getOrigin();

            for (int i = 0; i <= l; i++) {
                int a = other.indexOf(other.getText().charAt(i) + other.getOrigin());
                int b = this.indexOf(other.getText().charAt(i) + this.getOrigin());
                go = a == b;
            }
        }
        return go;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int randomPlzHelpInt = Math.min(this.text.length() - 1, this.origin + 100);
        for (int i = this.origin; i <= randomPlzHelpInt; i++) {
            if (i == this.position) {
                sb.append("[");
            }
            sb.append(this.text.charAt(i));
        }
        if (this.position > this.origin + 100) {
            sb.append("...[");
        }
        if (this.text.length() <= this.origin + 100) {
            sb.append("...]");
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

}
