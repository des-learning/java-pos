import java.util.Scanner;

/**
 * class ini menjalankan logic yang terkait navigasi menu
 *
 * class ini me-manage state yaitu berupa array of string
 * yang menjadi menu dan pilihan menu yang dipilih oleh user
 **/
public class MenuNavigation {
  private Scanner input;
  private String[] menu;
  private int selectedMenu;

  public MenuNavigation(String[] menu) {
    input = new Scanner(System.in);
    this.menu = menu;
    this.selectedMenu = 0;
  }

  public void showAndSelectMenu() {
    for (int i = 0; i < menu.length; i++) {
      System.out.printf("%d. %s\n", i + 1, menu[i]);
    }

    while (true) {
      try {
        System.out.printf("Menu (1-%d): ", menu.length);
        this.selectedMenu = Integer.parseInt(input.nextLine());
        break;
      } catch (Exception e) {
        // TODO: handle exception here
      }
    }
  }

  public int getSelectedMenu() {
    return this.selectedMenu;
  }
}