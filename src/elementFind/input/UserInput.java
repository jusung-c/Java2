package elementFind.input;

import elementFind.periodic.Phase;

import java.io.*;
import java.util.Arrays;

import static elementFind.periodic.Phase.names;

public class UserInput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 사용자가 원하는 command 입력받기
    public static String getCommandString() throws IOException {
        // 입력받은 값이 Phase 타입에 존재할 때까지 무한 루프
        while (true) {
            String s = br.readLine();

            // 유효한 command 값인지 검사
            if (isCommand(s)) {
                return s;
            } else {
                System.out.print("유효하지 않은 값입니다. 다시 입력해주세요. [e.g. number | name | symbol | weight | period | group | phase]: ");
            }
        }
    }

    // 유효한 command인지 검사
    private static boolean isCommand(String command) {

        // null이 아니고 유효한 commnad일 때만 true 리턴
        return command != null && (command.equals("number") ||
                command.equals("name") ||
                command.equals("symbol") ||
                command.equals("weight") ||
                command.equals("period") ||
                command.equals("group") ||
                command.equals("phase") ||
                command.equals("undo"));
    }

    // 조회하고 싶은 String 배열 입력받기
    public static String[] getStringArray() {
        String[] inputs;

        while (true) {
            try {
                inputs = br.readLine().split(" ");

                if (inputs.length == 0) {
                    System.out.println("다시 입력해주세요: ");
                } else {
                    return inputs;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 조회하고 싶은 phase 값 입력받기
    public static String getPhase() {
        String input = null;

        while (true) {
            try {
                input = br.readLine();

                if (!input.isEmpty()) {
                    for (Phase p : Phase.values()) {
                        if (p.toString().equals(input)) {
                            return input;
                        }
                    }
                    System.out.print("gas, liq, solid, artificial 중 하나를 입력해주세요: ");
                } else {
                    System.out.print("다시 입력해주세요: ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean getExitKey() throws IOException {
        System.out.print("계속하고 싶다면 Enter를, 종료하고 싶다면 'exit'을 입력해주세요. ");
        // 입력은 받아 공백 제거
        String exitInput = br.readLine().trim();
        String exit = "exit";

        // exit과 동일한지 판단 (대소문자 구분 X)
        return exit.equalsIgnoreCase(exitInput);
    }

    public static int getIntegerBetween(int min, int max) {
        int num;

        while (true) {
            try {
                num = Integer.parseInt(br.readLine());

                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.print(min + "과 " + max + " 사이의 값을 입력해주세요: ");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return num;
    }

    public static int[] getIntegerArrayBetween(int min, int max) {
        int[] numbers;

        while (true) {
            try {
                // 공백을 기준으로 입력받아 int[]로 변환
                numbers = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                boolean flag = false;

                for (int num : numbers) {
                    if (num < min || num > max) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.print(min + "과 " + max + " 사이의 값을 입력해주세요: ");
                    continue;
                }

                return numbers;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static double[] getDoubleArray() {
        double[] numbers;

        try {
            // 공백을 기준으로 입력받아 int[]로 변환
            numbers = Arrays.stream(br.readLine().split("~"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            return numbers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
