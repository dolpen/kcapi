package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 基礎情報
 */
public class MemberBasic {
    @SerializedName("api_active_flag")
    public int activeFlag; // 用途不明 いつも1

    @SerializedName("api_comment")
    public String comment; // メッセージ、情報画面で変更可能

    @SerializedName("api_comment_id")
    public String commentId; // 用途不明、数値文字列

    @SerializedName("api_count_deck")
    public int deckCount; // 艦隊数

    @SerializedName("api_count_kdock")
    public int buildDockCount; // 建造ドック数

    @SerializedName("api_count_ndock")
    public int repairDockCount; // 入渠ドック数

    @SerializedName("api_experience")
    public int exp; // 提督経験値

    @SerializedName("api_fcoin")
    public int furnitureCoin; // 家具コイン

    @SerializedName("api_firstflag")
    public int firstflag; // チュートリアルフラグ？

    //@SerializedName("api_fleetname")
    //public Object fleetName; // 用途不明 いつもnull

    @SerializedName("api_furniture")
    public List<Integer> furnitureIds; // 設置家具ID

    @SerializedName("api_large_dock")
    public int largeDockFlag; // 大型建造解禁

    @SerializedName("api_level")
    public int lv; // 提督レベル

    @SerializedName("api_max_chara")
    public int maxGirlCount; // 母港サイズ

    @SerializedName("api_max_kagu")
    public int maxFurnitureCount; // 家具所持最大数(形骸化)

    @SerializedName("api_max_slotitem")
    public int maxSlotItemCount; // 装備所持数

    @SerializedName("api_member_id")
    public String admiralId; // 提督ID、数値文字列

    @SerializedName("api_ms_count")
    public int missionCount; // 遠征数

    @SerializedName("api_ms_success")
    public int missionSuccess; // 遠征成功数

    @SerializedName("api_nickname")
    public String nickname; // ニックネーム、数値文字列

    @SerializedName("api_nickname_id")
    public String nicknameId; // 名前ID、数値文字列

    @SerializedName("api_playtime")
    public int playtime; // 用途不明

    @SerializedName("api_pt_challenged")
    public int challanged; // 被演習数？、常にゼロ

    @SerializedName("api_pt_challenged_win")
    public int challangedWin; // 被演習勝利数？、常にゼロ

    @SerializedName("api_pt_lose")
    public int practiceLose; // 演習敗北数

    @SerializedName("api_pt_win")
    public int practiceWin; // 演習勝利数

    @SerializedName("api_pvp")
    public List<Integer> pvp; // 設置家具ID

    @SerializedName("api_rank")
    public int rank; // 階級

    @SerializedName("api_st_lose")
    public int battleLose; // 海戦敗北数

    @SerializedName("api_st_win")
    public int battleWin; // 海戦勝利数

    @SerializedName("api_starttime")
    public long startTime; // 開始時刻

    @SerializedName("api_tutorial")
    public int tutorialFrag; // チュートリアル要否

    @SerializedName("api_tutorial_progress")
    public int tutorialProgress; // チュートリアル進捗
}
