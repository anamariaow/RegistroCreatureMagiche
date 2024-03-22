public class Exceptions {
    public static class DatiCreatureNonValidiException extends Exception {
        public DatiCreatureNonValidiException(String message) {
            super(message);
        }
    }

    public static class CreaturaNonTrovataException extends Exception {
        public CreaturaNonTrovataException(String message) {
            super(message);
        }
    }
}
