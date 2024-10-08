public class MainMenuScreen {
    private MenuNavigation menu;
    private boolean exit;

    public MainMenuScreen() {
        menu = new MenuNavigation(new String[]{
                "Managemen user",
                "Managemen inventori",
                "Transaksi penjualan",
                "Laporan",
                "Keluar",
        });
        resetState();
    }

    public void run() {
        while (!shouldExit()) {
            menu.showAndSelectMenu();

            switch (menu.getSelectedMenu()) {
                case 5:
                    exit = true;
            }
        }
        resetState();
    }

    private boolean shouldExit() {
        return exit;
    }

    private void resetState() {
        exit = false;
    }
}
