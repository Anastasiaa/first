/**
 * Created by Настя on 10.09.2014.
 */
import java.io.IOException;
import java.util.Scanner;
public class HarryPotterDay {

    public static void main(String[] args) {

        System.out.println("Обычный день из жизни Гарри Поттера");
        System.out.println("Нажимайте '1' в случае положительного ответа, иначе жмите '0'");
        System.out.println("");
        boolean dead = false;
        while (!dead) {
            printQuestion("Гарри Поттер проснулся?");
            if (readAnswer() == 1) {
                printQuestion("Сегодня выходные?");
                if (readAnswer() == 1) {
                    printQuestion("Отлично, тогда идем спасать мир?");
                    dead = saveWorld();
                } else {
                    printQuestion("Тогда Гарри идет на учебу?");
                    if (readAnswer() == 1) {
                        printQuestion("Может пнуть Рона?");
                        if (readAnswer() == 1) {
                            System.out.print("Завязалась драка, Гарри пропустил учебу и отправился на обед. Что его ждет дальше? ");
                            dead = forbiddenForest();
                        } else {
                            System.out.print("Гарри достаточно приличен, поэтому он просто отправился на учебу, а потом на обед, а что делать после обеда? ");
                            dead = forbiddenForest();
                        }
                    } else {
                        printQuestion("Отлично, тогда идем спасать мир?");
                        dead = saveWorld();
                    }
                }
            } else {
                printQuestion("Увы, Гарри Поттер не проснулся...");
                dead = true;
            }
        }
    }

    private static byte readAnswer() {
        Scanner readAnswer = new Scanner( System.in );
        String s = readAnswer.nextLine();
        byte a;
        while (!s.equals("1") && !s.equals("0")) {
            System.out.println("Введите ответ ввиде единицы или нуля!!!");
            s = readAnswer.nextLine();
        }
        a = Byte.parseByte(s);
        return a;
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    private static boolean saveWorld() {
        if (readAnswer() == 1) {
            printQuestion("Ура, наконец-то. А Волан-де-морт то жив?");
            if (readAnswer() == 1) {
                printQuestion("Ага, Гарри сел ждать опасность. Опасность пришла?");
                if (readAnswer() == 1) {
                    printQuestion("Гарри хорошенько навалял Волан-де-Морту! Вопрос только: выжил ли он сам?");
                    if (readAnswer() == 1) {
                        printQuestion("Дамблдор очень доволен Гарри, поэтому был устроен пир в Большом зале! После которого Гарри лег спать.");
                    } else {
                        printQuestion("Волан-де-Морт оказался сильнее...");
                        return true;
                    }
                } else {
                    printQuestion("Гарри жутко разочарован. В плохом настроении он ушел спать.");
                }
            } else {
                printQuestion("Гарри жутко разочарован. В плохом настроении он ушел спать.");
            }
        } else {
            System.out.print("Пусть мир подождет...");
            sneg();
        }
        return false;
    }

    private static void sneg() {
        printQuestion("Гарри пошел в гости к Хагриду. На обратном пути он напоролся на Снега?");
        if (readAnswer() == 1) {
            printQuestion("Минус 50 очков Гриффиндору!!! День кончился не очень то удачно, Гарри лег спать.");
        } else {
            printQuestion("Фух, пронесло! В хорошем настроении Гарри лег спать!");
        }
    }

    private static boolean forbiddenForest() {
        boolean dead = false;
        printQuestion("Может Запретный лес?");
        if (readAnswer() == 1) {
            printQuestion("Гарри оказался в опасном месте, он выжил?");
            if (readAnswer() == 1) {
                printQuestion("Тогда самое время спасать мир?");
                dead = saveWorld();
            } else {
                printQuestion("Гарри не удалось выйти живим из Запретного леса...");
                dead = true;
            }
        } else {
            printQuestion("Тогда игра в квидич?");
            if (readAnswer() == 1) {
                printQuestion("Сбить Малфоя?");
                if (readAnswer() == 1) {
                    printQuestion("Гарри очень рад! Гриффиндор победил и устроил пир в Большом зале! После такого насыщенного дня Гарри с радостью лег спать!");
                } else {
                    System.out.print("Гарри упал с метлы и повредил руку! ");
                    boolean hospital = false;
                    while (!hospital) {
                        printQuestion("Отправим Гарри в больничное крыло?");
                        if (readAnswer() == 1) {
                            printQuestion("Добби навестил своего больного друга, и Гарри в знак благодарности отдал Добби носок и лег спать.");
                            hospital = true;
                        } else {
                            printQuestion("Гарри хочет помощи от Рона?");
                            if (readAnswer() == 1) {
                                System.out.print("Всем известно, что Рон не очень силен в заклинаниях...");
                            } else {
                                printQuestion("Гермиона решила взять дело в свои руки и быстро вылечила друга, довольный Гарри лег спать.");
                                break;
                            }
                        }
                    }
                }
            } else {
                sneg();
            }
        }
        return dead;
    }
}
