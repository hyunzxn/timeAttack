import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract class Player{
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<String>();
    private Boolean isEnd;

    public Player(String name, String initNumber) { // Player class의 생성자
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }
    public abstract void play(String number) throws Exception;
    public void addFightList(String number) { fightList.add(number); }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public String getInitNumber() { return initNumber; }
    public String getName() { return name; }
    public void printFightList() { // fight 기록이 들어가는 리스트를 출력해주는 메소드
        System.out.println(name);
        System.out.println("-----------------");
        int i = 1;
        for (String fight : fightList) {
            System.out.println(i + ": " + fight);
            i++;
        }
        System.out.println("-----------------");
    }
}
class PlayerATeam extends Player
{
    public PlayerATeam(String name, String number) { // PlayerATeam의 생성자
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        // TODO
        String initNum = getInitNumber(); // initNumber 받기
        for (int i = 0; i < initNum.length(); i++) {
            if (initNum.charAt(i) == number.charAt(i)) { // initNum의 각 자리 숫자랑 사용자가 입력한 각 자리 숫자 비교
                strike += 1;
            } else {
                if (number.indexOf(initNum.charAt(i)) != -1) { // initNum의 각 자리 숫자가 사용자가 입력한 각 자리 숫자에 포함되는지 확인
                    ball += 1;
                } else {
                    out += 1;
                }
            }
        }

        if(strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }

        super.addFightList(number + " Strike: " + strike + " ,Ball: " + ball + " ,Out: " + out);
    }
}

class PlayerBTeam extends Player
{
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }
    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        // TODO
        String initNum = getInitNumber(); // initNumber 받기
        for (int i = 0; i < initNum.length(); i++) {
            if (initNum.charAt(i) == number.charAt(i)) { // initNum의 각 자리 숫자랑 사용자가 입력한 각 자리 숫자 비교
                ball += 1;
            } else {
                if (number.indexOf(initNum.charAt(i)) != -1) { // initNum의 각 자리 숫자가 사용자가 입력한 각 자리 숫자에 포함되는지 확인
                    strike += 1;
                } else {
                    out += 1;
                }
            }
        }

        if(ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+ ", Ball : "+ball+", Out: "+out);
        }

        super.addFightList(number + " Strike: " + strike + " ,Ball: " + ball + " ,Out: " + out);
    }
}

// main 함수 건드리지 않는다.
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team","1234"), new PlayerBTeam("B Team","5678")};
        int checkPlayer = 0;

        while(true) {
            checkPlayer = 0;
            for(Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if(checkPlayer == playerArray.length) break;
        }

        for(Player player : playerArray) {
            player.printFightList();
        }
    }
}
