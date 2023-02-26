package yachu;

import java.util.Arrays;
import java.util.Scanner;

public class Runningprogram {
	int player1[] = new int[13];
	boolean player1check[] = new boolean[13];
	int player2[] = new int[13];
	boolean player2check[] = new boolean[13];
	public static final String FONT_CYAN = "\u001B[36m";
	public static final String RESET = "\u001B[0m";
	public static final String FONT_RED = "\u001B[31m";
	boolean NumSum_player1 = false;
	boolean NumSum_player2 = false;
	int p1score = 0;
	int p2score = 0;
	
	public Runningprogram() {
		Scanner sc = new Scanner(System.in);
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println(FONT_CYAN + "                 YACHT                 " + RESET);
		System.out.println("          게임을 시작하려면 엔터를 누르세요.          ");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		String temp = sc.nextLine();
		ABCD(player1, player2);
	}

	// 랜덤배열 확인할 때 간혹 잘못 출력되는 버그, 수정했을 때 발생하는 버그
	public void ABCD(int[] a, int[] b) {
		String NowPlayer = "player1";
		for (int index = 0; index < 24; index++) {
			int Random[] = new int[5];
			int temp_list[] = new int[5];
			int count = 3;
			int variable_num = 5;
			while (count > 0) {
				int temp = 0;
				int counter[] = new int[6];
				Scanner sc = new Scanner(System.in);
				System.out.println(FONT_CYAN + "주사위를 굴립니다. 남은 횟수는 " + (count - 1) + "번" + RESET);
				System.out.println("현재 뽑은 수");
				for (int i = 0; i < variable_num; ++i) {
					Random[i] = (int) (Math.random() * 6) + 1;
					System.out.print(Random[i] + " ");
				}
				System.out.println("");
				System.out.println("내가 킵한 수");
				for (int i = variable_num; i < 5; ++i) {
					System.out.print(Random[i] + " ");
				}
				System.out.println("");
				for (int i = 0; i < 5; i++) {
					for (int j = 1; j <= 6; j++) {
						if (Random[i] == j) {
							counter[j - 1]++;
							break;
						}
					}
				}
				if (NowPlayer == "player1") {
					One(counter);
					if (player1check[0] == false)
						Oneprint(counter, NowPlayer);
					Two(counter);
					if (player1check[1] == false)
						Twoprint(counter, NowPlayer);
					Three(counter);
					if (player1check[2] == false)
						Threeprint(counter, NowPlayer);
					Four(counter);
					if (player1check[3] == false)
						Fourprint(counter, NowPlayer);
					Five(counter);
					if (player1check[4] == false)
						Fiveprint(counter, NowPlayer);
					Six(counter);
					if (player1check[5] == false)
						Sixprint(counter, NowPlayer);
//			Numsum(player1, player1check);
					Choice(Random, player1check);
					if (player1check[7] == false)
						Choiceprint(Random, player1check, NowPlayer);
					FofaKind(Random, player1check, counter);
					if (player1check[8] == false)
						FofaKindprint(Random, player1check, counter, NowPlayer);
					FullHouse(Random, player1check, counter);
					if (player1check[9] == false)
						FullHouseprint(Random, player1check, counter, NowPlayer);
					SStraight(Random, player1check, counter);
					if (player1check[10] == false)
						SStraightprint(Random, player1check, counter, NowPlayer);
					LStraight(Random, player1check, counter);
					if (player1check[11] == false)
						LStraightprint(Random, player1check, counter, NowPlayer);
					Yacht(Random, player1check, counter);
					if (player1check[12] == false)
						Yachtprint(Random, player1check, counter, NowPlayer);
				} else if (NowPlayer == "player2") {
					One(counter);
					if (player2check[0] == false)
						Oneprint(counter, NowPlayer);
					Two(counter);
					if (player2check[1] == false)
						Twoprint(counter, NowPlayer);
					Three(counter);
					if (player2check[2] == false)
						Threeprint(counter, NowPlayer);
					Four(counter);
					if (player2check[3] == false)
						Fourprint(counter, NowPlayer);
					Five(counter);
					if (player2check[4] == false)
						Fiveprint(counter, NowPlayer);
					Six(counter);
					if (player2check[5] == false)
						Sixprint(counter, NowPlayer);
//				Numsum(player2, player1check);
					Choice(Random, player2check);
					if (player2check[7] == false)
						Choiceprint(Random, player2check, NowPlayer);
					FofaKind(Random, player2check, counter);
					if (player2check[8] == false)
						FofaKindprint(Random, player2check, counter, NowPlayer);
					FullHouse(Random, player2check, counter);
					if (player2check[9] == false)
						FullHouseprint(Random, player2check, counter, NowPlayer);
					SStraight(Random, player2check, counter);
					if (player2check[10] == false)
						SStraightprint(Random, player2check, counter, NowPlayer);
					LStraight(Random, player2check, counter);
					if (player2check[11] == false)
						LStraightprint(Random, player2check, counter, NowPlayer);
					Yacht(Random, player2check, counter);
					if (player2check[12] == false)
						Yachtprint(Random, player2check, counter, NowPlayer);
				}
				if (count != 1)
					System.out.println(FONT_CYAN + "Keep하고자 하는 Index를 쓰세요. 없다면 0을 쓰세요." + RESET);
				while (true) {
					int num = 0;
					// 실수로 동일한 넘버를 적었을 경우에도 오류를 출력(variable_num 변수에 감소 영향을 주기 때문)
					if (count != 1)
						num = sc.nextInt();
					if (variable_num != 0) {
						try {
							if (num != 0) {
								temp_list[temp] = Random[num - 1];
								Random[num - 1] = 7;
								temp++;
								variable_num--;
							} else {
								for (temp = 0; temp < 5; temp++) {
									if (temp_list[temp] != 0) {
										Random[temp] = 7;
									}
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) { // 인덱스 범위에서 벗어난 숫자를 입력한 경우
							temp = 0;
							variable_num = 5;
							System.out.println(FONT_RED + "잘못된 Index를 작성했습니다. 다시 작성하세요. 없다면 0을 쓰세요." + RESET);
						}
					}
					if (count == 1) {
						System.out.println(FONT_CYAN
								+ "남은 횟수는 0번입니다. 현재 본인이 선택한 Index는 아래와 같습니다. 저장하려는 곳의 알파벳을 찾아 누르세요. (Signal 0)"
								+ RESET);
						Arrays.sort(Random);
						Arrays.sort(temp_list);

						for (int i = variable_num; i < 5; ++i) {
							Random[i] = temp_list[i];
						}
						for (int i = 0; i < 5; ++i) {
							System.out.print(FONT_CYAN + Random[i] + " ");
						}
						System.out.println(RESET);
						if (NowPlayer == "player1") {
							Selectprint(Random, player1check, counter);
							PutInList(counter, player1check, player1, Random, NowPlayer);
							break;
						} else if (NowPlayer == "player2") {
							Selectprint(Random, player2check, counter);
							PutInList(counter, player2check, player2, Random, NowPlayer);
							break;
						}
						count--;
					} else if (num == 0 && variable_num == 0) {
						System.out.println(FONT_CYAN + "남은 횟수는 " + (count - 1)
								+ "번입니다. 현재 본인이 선택한 Index와 선택했던 Index는 아래와 같습니다. 아래의 수들에 본인의 점수를 기록하려면 Y를(수정 불가), 수정하고 싶으면 Y를 제외한 다른 키를 누르세요.(Signal 1)"
								+ RESET);
						Arrays.sort(Random);
						Arrays.sort(temp_list);
						for (int i = variable_num; i < 5; ++i) {
							Random[i] = temp_list[i];
							System.out.print(FONT_CYAN + Random[i] + " ");
						}
						System.out.println(RESET);
						String res = sc.next();
						if (res.equals("Y") || res.equals("y")) {
							Arrays.sort(Random);
							Arrays.sort(temp_list);
							for (int i = variable_num; i < 5; ++i) {
								Random[i] = temp_list[i];
							}
							for (int i = 0; i < 5; ++i) {
								System.out.print(FONT_CYAN + Random[i] + " ");
							}
							System.out.println(RESET);
							if (NowPlayer == "player1") {
								Selectprint(Random, player1check, counter);
								PutInList(counter, player1check, player1, Random, NowPlayer);
								count = 0;
								break;
							} else if (NowPlayer == "player2") {
								Selectprint(Random, player2check, counter);
								PutInList(counter, player2check, player2, Random, NowPlayer);
								count = 0;
								break;
							}
						} else {
							temp = 0;
							variable_num = 5;
							System.out.println(FONT_CYAN + "Keep하고자 하는 Index를 쓰세요. 없다면 0을 쓰세요." + RESET);
						}
					} else if (num == 0 && variable_num != 0) {
						System.out.println(FONT_CYAN + "남은 횟수는 " + (count - 1)
								+ "번입니다. 현재 본인이 선택한 Index와 선택했던 Index는 아래와 같습니다. 아래의 수를 Keep한 다음 주사위를 굴릴려면 Y를(수정 불가), 수정하고 싶으면 Y를 제외한 다른 키를 누르세요.(Signal 2)"
								+ RESET);
						Arrays.sort(Random);
						Arrays.sort(temp_list);
						for (int i = variable_num; i < 5; ++i) {
							Random[i] = temp_list[i];
							System.out.print(FONT_CYAN + Random[i] + " ");
						}
						System.out.println(RESET);
						String res = sc.next();
						if (res.equals("Y") || res.equals("y")) {
							break;
						} else {
							temp = 0;
							variable_num = 5;
							System.out.println(FONT_CYAN + "Keep하고자 하는 Index를 쓰세요. 없다면 0을 쓰세요." + RESET);
						}
					}
				}
				--count;
			}
			if (NowPlayer == "player1" && (NumSum_player1 == false)) {
				if ((player1check[0] == true) && (player1check[1] == true) && (player1check[2] == true)
						&& (player1check[3] == true) && (player1check[4] == true) && (player1check[5] == true)) {
					if (player1[0] + player1[1] + player1[2] + player1[3] + player1[4] + player1[5] >= 63) {
						Numsum(player1, player1check);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println(FONT_CYAN + "player1님의 One~Six의 총합이 63을 넘어섰으므로 추가 점수 35점을 획득했습니다." + RESET);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						player1[6] = 35;
						NumSum_player1 = true;
					} else {
						Numsum(player1, player1check);
						System.out.println(FONT_RED + "★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("player1님의 One~Six의 총합이 63을 넘지 못하여 추가 점수 35점을 획득하지 못했습니다." + RESET);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆" + RESET);
						player1[6] = 0;
						NumSum_player1 = true;
					}
				}
			}
			if (NowPlayer == "player2" && (NumSum_player2 == false)) {
				if ((player2check[0] == true) && (player2check[1] == true) && (player2check[2] == true)
						&& (player2check[3] == true) && (player2check[4] == true) && (player2check[5] == true)) {
					if (player2[0] + player2[1] + player2[2] + player2[3] + player2[4] + player2[5] >= 63) {
						Numsum(player2, player2check);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println(FONT_CYAN + "player2님의 One~Six의 총합이 63을 넘어섰으므로 추가 점수 35점을 획득했습니다." + RESET);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						player2[6] = 35;
						NumSum_player2 = true;
					} else {
						Numsum(player2, player2check);
						System.out.println(FONT_RED + "★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("player2님의 One~Six의 총합이 63을 넘지 못하여 추가 점수 35점을 획득하지 못했습니다." + RESET);
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆" + RESET);
						player2[6] = 0;
						NumSum_player2 = true;
					}
				}
			}
			if (NowPlayer == "player1") {
				NowPlayer = "player2";
			} else if (NowPlayer == "player2") {
				NowPlayer = "player1";
			}
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println(FONT_CYAN + "턴이 종료되었습니다. " + NowPlayer + "님의 차례입니다." + RESET);
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");

//		printlist(a, b);
		}
		System.out.println("======================================");
		System.out.println(FONT_RED + "게임이 종료되었습니다." + RESET);
		System.out.println("======================================");
		for (int i = 0; i<12; i++) {
			p1score += player1[i];
			p2score += player2[i];
		}
		System.out.println(FONT_RED + "One Two Three Four Five Six BonusScore Choice FourOfaKind FullHouse SmallStraight LargeStraight Yacht" + RESET);
		printlist(player1);
		printlist(player2);
		System.out.println("======================================");
		System.out.print(FONT_RED + "player1님의 총점은 " + p1score + ", player2님의 총점은 "+ p2score + "점으로 " + RESET);
		if (p1score > p2score) {
			System.out.print(FONT_RED + (p1score - p2score) + "점 차이로 player1님의 승리입니다!" + RESET);
			System.out.println("======================================");
		} else if (p1score < p2score) {
			System.out.print(FONT_RED + (p2score - p1score) + "점 차이로 player2님의 승리입니다!" + RESET);
			System.out.println("======================================");
		} else {
			System.out.print(FONT_RED + "무승부입니다!" + RESET);
			System.out.println("======================================");
		}
	}

	private boolean One(int[] a) {
		if (a[0] != 0)
			return true;
		else
			return false;
	}

	public void Oneprint(int[] a, String NowPlayer) {
		if (One(a))
			System.out.println(NowPlayer + "의 One에 들어갈 수는 " + a[0] * 1 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 One에 들어갈 수는 0입니다.");
	}

	private boolean Two(int[] a) {
		if (a[1] != 0)
			return true;
		else
			return false;
	}

	public void Twoprint(int[] a, String NowPlayer) {
		if (Two(a))
			System.out.println(NowPlayer + "의 Two에 들어갈 수는 " + a[1] * 2 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Two에 들어갈 수는 0입니다.");
	}

	private boolean Three(int[] a) {
		if (a[2] != 0)
			return true;
		else
			return false;
	}

	public void Threeprint(int[] a, String NowPlayer) {
		if (Three(a))
			System.out.println(NowPlayer + "의 Three에 들어갈 수는 " + a[2] * 3 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Three에 들어갈 수는 0입니다.");
	}

	private boolean Four(int[] a) {
		if (a[3] != 0)
			return true;
		else
			return false;
	}

	public void Fourprint(int[] a, String NowPlayer) {
		if (Four(a))
			System.out.println(NowPlayer + "의 Four에 들어갈 수는 " + a[3] * 4 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Four에 들어갈 수는 0입니다.");
	}

	private boolean Five(int[] a) {
		if (a[4] != 0)
			return true;
		else
			return false;
	}

	public void Fiveprint(int[] a, String NowPlayer) {
		if (Five(a))
			System.out.println(NowPlayer + "의 Five에 들어갈 수는 " + a[4] * 5 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Five에 들어갈 수는 0입니다.");
	}

	private boolean Six(int[] a) {
		if (a[5] != 0)
			return true;
		else
			return false;
	}

	public void Sixprint(int[] a, String NowPlayer) {
		if (Six(a))
			System.out.println(NowPlayer + "의 Six에 들어갈 수는 " + a[5] * 6 + "입니다." + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Six에 들어갈 수는 0입니다.");
	}

	private void Numsum(int[] a, boolean[] b) {
		int num = 0;
		int i = 0;
		while (i <= 5) {
			if (b[i] == true) {
				num += a[i];
				i++;
			} else
				i++;
		}
		a[6] = num;
		System.out.println(
				FONT_CYAN + "현재 당신의 One~Six의 합은 " + (a[0] + a[1] + a[2] + a[3] + a[4] + a[5]) + "입니다." + RESET);
	}

	private int Choice(int[] a, boolean[] b) {
		int num = 0;
		if (b[7] == false) {
			for (int i = 0; i < 5; i++) {
				num += a[i];
			}
			return num;
		}
		return 0;
	}

	private void Choiceprint(int[] a, boolean[] b, String NowPlayer) {
		if (b[7] == false)
			System.out.println(NowPlayer + "의 Choice에 들어갈 수는 " + Choice(a, b) + "입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Choice에 들어갈 수는 0입니다.");
	}

	private int FofaKind(int[] a, boolean[] b, int[] c) {
		int num = 0;
		if (b[8] == false) {
			for (int i = 0; i < 6; i++) {
				if (c[i] == 4) {
					for (int j = 0; j < 5; j++) {
						num += a[j];
					}
				}
			}
			if (num != 0) {
				return num;
			}
		}
		return 0;
	}

	private void FofaKindprint(int[] a, boolean[] b, int[] c, String NowPlayer) {
		if (b[8] == false && (FofaKind(a, b, c) > 0))
			System.out.println(NowPlayer + "의 Four of a Kind에 들어갈 수는 " + FofaKind(a, b, c) + "입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Four of a Kind에 들어갈 수는 0입니다.");
	}

	private int FullHouse(int[] a, boolean[] b, int[] c) {
		int num = 0;
		boolean check2 = false;
		int temp2 = 0;
		boolean check3 = false;
		int temp3 = 0;
		if (b[9] == false) {
			for (int i = 0; i < 5; i++) {
				if (c[i] == 2) {
					check2 = true;
					temp2 = i + 1;
				} else if (c[i] == 3) {
					check3 = true;
					temp3 = i + 1;
				}
			}
			if (check2 && check3 == true) {
				for (int i = 0; i < 5; i++) {
					num += a[i];
				}
				return num;
			}
		}
		return 0;
	}

	private void FullHouseprint(int[] a, boolean[] b, int[] c, String NowPlayer) {
		if (b[9] == false && (FullHouse(a, b, c) > 0))
			System.out.println(NowPlayer + "의 FullHouse에 들어갈 수는 " + FullHouse(a, b, c) + "입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 FullHouse에 들어갈 수는 0입니다.");
	}

	private boolean SStraight(int[] a, boolean[] b, int[] c) {
		int count = 0;
		int num = 0;
		if (b[10] == false) {
			for (num = 0; num < 3; num++) {
				if (c[num] > 0 && c[num] <= 2 && c[num + 1] > 0 && c[num + 1] <= 2 && c[num + 2] > 0 && c[num + 2] <= 2
						&& c[num + 3] > 0 && c[num + 3] <= 2) {
					return true;
				}
			}
		}
		return false;
	}

	private void SStraightprint(int[] a, boolean[] b, int[] c, String NowPlayer) {
		if (b[10] == false && SStraight(a, b, c) == true)
			System.out.println(NowPlayer + "의 S.Straight에 들어갈 수는 15입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 S.Straight에 들어갈 수는 0입니다.");
	}

	private boolean LStraight(int[] a, boolean[] b, int[] c) {
		if (b[11] == false) {
			if (c[1] == 1 && c[2] == 1 && c[3] == 1 && c[4] == 1 && c[5] == 1
					|| c[0] == 1 && c[1] == 1 && c[2] == 1 && c[3] == 1 && c[4] == 1) {
				return true;
			}
		}
		return false;
	}

	private void LStraightprint(int[] a, boolean[] b, int[] c, String NowPlayer) {
		if (b[11] == false && LStraight(a, b, c) == true)
			System.out.println(NowPlayer + "의 L.Straight에 들어갈 수는 30입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 L.Straight에 들어갈 수는 0입니다.");
	}

	private boolean Yacht(int[] a, boolean[] b, int[] c) {
		int count = 0;
		if (b[12] == false) {
			if (a[0] == a[1] && a[1] == a[2] && a[2] == a[3] && a[3] == a[4]) {
				return true;
			}
		}
		return false;
	}

	private void Yachtprint(int[] a, boolean[] b, int[] c, String NowPlayer) {
		if (b[12] == false && Yacht(a, b, c) == true)
			System.out.println(NowPlayer + "의 Yacht에 들어갈 수는 50입니다."  + FONT_RED + " ★" + RESET);
		else
			System.out.println(NowPlayer + "의 Yacht에 들어갈 수는 0입니다.");
	}

	private void Selectprint(int[] a, boolean[] b, int[] c) {
		System.out.println(FONT_CYAN + "원하는 항목을 선택하세요." + RESET);
		if (b[0] == false) {
			System.out.print(FONT_CYAN + "One은 숫자 1을, " + RESET);
		}
		if (b[1] == false) {
			System.out.print(FONT_CYAN + "Two는 숫자 2를, " + RESET);
		}
		if (b[2] == false) {
			System.out.print(FONT_CYAN + "Three는 숫자 3을, " + RESET);
		}
		if (b[3] == false) {
			System.out.print(FONT_CYAN + "Four는 숫자 4를, " + RESET);
		}
		if (b[4] == false) {
			System.out.print(FONT_CYAN + "Five는 숫자 5를, " + RESET);
		}
		if (b[5] == false) {
			System.out.print(FONT_CYAN + "Six는 숫자 6을, " + RESET);
		}
		if (b[7] == false) {
			System.out.println(FONT_CYAN + "Choice은 알파벳 C를, " + RESET);
		}
		if (b[8] == false) {
			System.out.print(FONT_CYAN + "Four of a kind는 알파벳 F를, " + RESET);
		}
		if (b[9] == false) {
			System.out.print(FONT_CYAN + "Full house는 알파벳 H를, " + RESET);
		}
		if (b[10] == false) {
			System.out.print(FONT_CYAN + "Small Straight는 알파벳 S를, " + RESET);
		}
		if (b[11] == false) {
			System.out.print(FONT_CYAN + "Large Straight는 알파벳 L를, " + RESET);
		}
		if (b[12] == false) {
			System.out.print(FONT_CYAN + "Yacht는 알파벳 Y를 " + RESET);
		}
		System.out.print(FONT_CYAN + "누르세요. (누르는 순간 수정 불가)" + RESET);
		System.out.println("");
	}

	private void PutInList(int counter[], boolean playercheck[], int player[], int Random[], String NowPlayer) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String res = sc.next();
			if (playercheck[0] == true && (res.equals("1"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[1] == true && (res.equals("2"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
			} else if (playercheck[2] == true && (res.equals("3"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[3] == true && (res.equals("4"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[4] == true && (res.equals("5"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[5] == true && (res.equals("6"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[7] == true && (res.equals("C") || res.equals("c"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[8] == true && (res.equals("F") || res.equals("f"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[9] == true && (res.equals("H") || res.equals("h"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[10] == true && (res.equals("S") || res.equals("s"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[11] == true && (res.equals("L") || res.equals("l"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			} else if (playercheck[12] == true && (res.equals("Y") || res.equals("y"))) {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				continue;
			}
			if (res.equals("1")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 One 자리에 값 " + (counter[0] * 1) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[0] = true;
				player[0] = counter[0] * 1;
				break;
			} else if (res.equals("2")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Two 자리에 값 " + (counter[1] * 2) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[1] = true;
				player[1] = counter[1] * 2;
				break;
			} else if (res.equals("3")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Three 자리에 값 " + (counter[2] * 3) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[2] = true;
				player[2] = counter[2] * 3;
				break;
			} else if (res.equals("4")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Four 자리에 값 " + (counter[3] * 4) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[3] = true;
				player[3] = counter[3] * 4;
				break;
			} else if (res.equals("5")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Five 자리에 값 " + (counter[4] * 5) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[4] = true;
				player[4] = counter[4] * 5;
				break;
			} else if (res.equals("6")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Six 자리에 값 " + (counter[5] * 6) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[5] = true;
				player[5] = counter[5] * 6;
				break;
			} else if (res.equals("C") || res.equals("c")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Choice 자리에 값 " + Choice(Random, playercheck)
						+ "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[7] = true;
				player[7] = Choice(Random, playercheck);
				break;
			} else if (res.equals("F") || res.equals("f")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Four Of a Kind 자리에 값 "
						+ FofaKind(Random, playercheck, counter) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[8] = true;
				player[8] = FofaKind(Random, playercheck, counter);
				break;
			} else if (res.equals("H") || res.equals("h")) {
				System.out.print(FONT_CYAN + NowPlayer + "님의 Full House 자리에 값 "
						+ FullHouse(Random, playercheck, counter) + "을(를) 넣었습니다." + RESET);
				System.out.println("");
				playercheck[9] = true;
				player[9] = FullHouse(Random, playercheck, counter);
				break;

			} else if (res.equals("S") || res.equals("s")) {
				if (SStraight(Random, playercheck, counter) == true) {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Small Straight 자리에 값 15를 넣었습니다." + RESET);
					System.out.println("");
					player[10] = 15;
				} else {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Small Straight 자리에 값 0을 넣었습니다." + RESET);
					System.out.println("");
					player[10] = 0;
				}
				playercheck[10] = true;
				break;

			} else if (res.equals("L") || res.equals("l")) {
				if (LStraight(Random, playercheck, counter) == true) {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Large Straight 자리에 값 30을 넣었습니다." + RESET);
					System.out.println("");
					player[11] = 30;
				} else {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Large Straight 자리에 값 0을 넣었습니다." + RESET);
					System.out.println("");
					player[11] = 0;
				}
				playercheck[11] = true;
				break;

			} else if (res.equals("Y") || res.equals("y")) {
				if (Yacht(Random, playercheck, counter) == true) {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Yacht 자리에 값 50을 넣었습니다." + RESET);
					System.out.println("");
					player[12] = 50;
				} else {
					System.out.print(FONT_CYAN + NowPlayer + "님의 Yacht 자리에 값 0을 넣었습니다." + RESET);
					System.out.println("");
					player[12] = 0;
				}
				playercheck[12] = true;
				break;
			} else {
				System.out.println(FONT_CYAN + "잘못 입력하셨습니다. 다시 입력해주세요." + RESET);
				break;
			}
		}
	}

//	private boolean isFull(boolean a[]) {
//		for (int i = 0; i < 13; i++) {
//			if (a[i] == false) {
//				return false;
//			}
//		}
//		return true;
//	}
	private void printlist(int[] a) {
		for (int i = 0; i<12; i++) {
			System.out.print(" / " + a[i] + " / ");
		}
	}
}
