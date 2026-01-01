package org.delcom.app.views;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeView {

    // 1. UPDATE STRUKTUR DATA (Tambah variabel objectPosition)
    public static class MediaItem {
        public int id;
        public String type;
        public String title;
        public String coverImage;
        public List<String> photoPaths;
        public List<String> videoPaths;
        public String audioPath;
        public String shortDesc;
        public String fullDesc;
        public String buttonText;
        public String objectPosition; // <--- VARIABEL BARU (Posisi Crop)

        public MediaItem(int id, String type, String title, String coverImage, 
                         List<String> photoPaths, List<String> videoPaths, 
                         String audioPath, String shortDesc, String fullDesc, 
                         String buttonText, String objectPosition) { // <--- Tambah disini
            this.id = id;
            this.type = type;
            this.title = title;
            this.coverImage = coverImage;
            this.photoPaths = photoPaths;
            this.videoPaths = videoPaths;
            this.audioPath = audioPath;
            this.shortDesc = shortDesc;
            this.fullDesc = fullDesc;
            this.buttonText = buttonText;
            this.objectPosition = objectPosition; // <--- Simpan disini
        }
    }

    // 2. DATA MANUAL (Updated dengan Kata-Kata Tombol Unik)
    private List<MediaItem> getMediaList() {
        List<MediaItem> list = new ArrayList<>();

        // ======================= FOTO (1-25) =======================
        
        // Foto 1
        list.add(new MediaItem(1, "PHOTO", "OMAIGAATT APAANII CANTIKK BANGETT", "/assets/foto/cantik14.jpeg", 
            List.of("/assets/foto/cantik14.jpeg", "/assets/foto/cantik14-2.jpeg"), Collections.emptyList(), "/assets/musik/lagu1.mp3", 
            "Tess", 
            "duhh cantikk bangett sii kamuu, kalo aku liat foto ini tuu yaa rasanya kek axquvcuqxsqbibo (*salting) hahahaa, soalnya kamu secantikk ituu, gemeess bangett pokoknyaa aku sukaa hihii❤️❤️",
            "klik ini ayy ada yg lucu tau hihi", // <--- Kata tombol unik
            "center 35%"
        ));

        // Foto 2
        list.add(new MediaItem(2, "PHOTO", "DUHHH INI JUGAA CANTIKK BANGETT", "/assets/foto/cantik5.jpeg", 
            List.of("/assets/foto/cantik5.jpeg", "/assets/foto/cantik5-2.jpeg", "/assets/foto/cantik5-3.jpeg"), Collections.emptyList(), "/assets/musik/lagu19.mp3", 
            "Short desc hidden", 
            "akuu seneng bangett liat kamu di fotoo inii, apalagii foto pertama tuu kek lucu bangett ihh kek kamu seolah' 'BAAAAA' gitu hahaa cutee bangett, fotoo kedua sama ketigaa juga cantikk, aku liatin terus tauu foto kamu yg pose telunjuk di pipii tuu soalnya imuutt bangett mmuuaahh",
            "liat dehh, kamu lucuu bgtt tau disini",
            "center 75%"
        ));

        // Foto 3
        list.add(new MediaItem(3, "PHOTO", "EEHHH ADAA KOLASEE FOTOO BIDADARII NIII", "/assets/foto/cantik6.jpeg", 
            List.of("/assets/foto/cantik6.jpeg", "/assets/foto/cantik6-2.jpeg"), Collections.emptyList(), "/assets/musik/lagu25.mp3", "Short desc", "sama kek lagunyaa setiap aku liatt kamu di kolase fotoo ini akunyaa jadi meltingg alias saltingg HAHAHHAA, soalnyaa kamu alwayss buat aku saltiingg apalagi kalo liatt pap cantikk dan gemess dari kamuu",
            "kamuu harus liat sii",
            "bottom"
        ));

        // Foto 4
        list.add(new MediaItem(4, "PHOTO", "WIII ADA FOTOO BIDADARII LAGII", "/assets/foto/cantik2.jpeg", 
            List.of("/assets/foto/cantik2.jpeg"), Collections.emptyList(), "/assets/musik/lagu15.mp3", "Short desc", "HEEYY INII KAMUU SENYUMNYAA KOK MANIISS BANGEETT SIII ARRGGHHH, JANGANN MANISS' DONG NANTI KALO BANYAK YG SUKAA SAMA KAMU AKU JADI CEMBURUU TAUU:(",
            "nyesel sii kalo kamu ga buka hahhaa",
            "center 10%"
        ));

        // Foto 5
        list.add(new MediaItem(5, "PHOTO", "EEHHH ADA BIDADARII LAGII POSE CANTIIKK", "/assets/foto/cantik4.jpeg", 
            List.of("/assets/foto/cantik4.jpeg", "/assets/foto/cantik4-2.jpeg"), Collections.emptyList(), "/assets/musik/lagu7.mp3", "Short desc", "duuhh posee apalagii ini yaa Tuhann lucuu bangett... posee kamu tuu loo aku jadi ngebayanginn kamu nungguin akuu pake pose kya gituu hahaha gemess naaa, cantikk kalii wooii akuu gaa kuatt TOLOONGGG",
            "yakin kamu ga kepo? wkwkw",
            "center 10%"
        ));

        /// ... (Kode Foto 1 s.d 5 biarkan saja di atas) ...

        // ========================================================
        // TEMPLATE MANUAL FOTO 6 s.d 25
        // ========================================================

        // --- FOTO KE-6 ---
        list.add(new MediaItem(6, "PHOTO", 
            "WIII ADAA FOTOO CANTIKK LAGII NIII",  // GANTI JUDUL
            "/assets/foto/cantik1.jpeg", // GANTI COVER
            List.of("/assets/foto/cantik1.jpeg", "/assets/foto/cantik1-2.jpeg", "/assets/foto/cantik1-3.jpeg", "/assets/foto/cantik1-4.jpeg"), // GANTI FOTO (Bisa tambah: "/uploads/foto/foto6_b.jpg")
            Collections.emptyList(), 
            "/assets/musik/lagu11.mp3", // GANTI LAGU
            "Short desc", 
            "ntann? itu bibirr atau strawberry? astagaa pinkk bangett hahahaa, ditambah lagi kamunyaa cantikk behh makin perfe☪️✝️ dehh, ehh aduhh maap kepencett wkwkwk", // GANTI DESKRIPSI
            "bole dong ini nya di klik' haha",
            "center 8%" // GANTI KATA TOMBOL
        ));

        // --- FOTO KE-7 ---
        list.add(new MediaItem(7, "PHOTO", 
            "NTAANN CANTIKNYAA BISAA DIKURANGIN GAA SII", 
            "/assets/foto/cantik3.jpeg", 
            List.of("/assets/foto/cantik3.jpeg", "/assets/foto/cantik3-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu10.mp3", 
            "Short desc", 
            "kalo semisall ketemu nii kan terus kamu natapp aku kya di fotoo ini behh gaa kebayangg lagii gimana saltingnyaa akuu, bisa' tantrumm tiap ditatap sama kamuu, sama kya lagunyaa kamu tuu bagaikan bungaa paling indah yang selalu menghiasii hari' akuu, jangan layuu yaa? kamu harus tetapp mekar dan mewangii okaayy?",
            "kalo kata aku si harus dipencet ya",
            "center 5%"
        ));

        // --- FOTO KE-8 ---
        list.add(new MediaItem(8, "PHOTO", 
            "EEHHH INII JAKETT UNGUNYAA KOK BAGUSS BANGETT YAA?", 
            "/assets/foto/cantik7.jpeg", 
            List.of("/assets/foto/cantik7.jpeg", "/assets/foto/cantik7-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu5.mp3", 
            "Short desc", 
            "akuu bingung nii ntann, aku salfok gara' jakett ungu kamu yg baguss atau karna kamunyaa yg cantikk yaa?HAHAHAA kyanya dua duanyaa gaa sii? soalnya ituu jaketnyaa bagus karna dipakee sama cewe cantikk kya kamuu, mmuuaahh",
            "klik dong kalo kamu kepo",
            "center 7%"
        ));

        // --- FOTO KE-9 ---
        list.add(new MediaItem(9, "PHOTO", 
            "PANTESS GULAA DI ASRAMA ABISS MULUU", 
            "/assets/foto/cantik8.jpeg", 
            List.of("/assets/foto/cantik8.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu8.mp3", 
            "Short desc", 
            "sumpahh senyum kamuu di foto ini sama kya lagunyaa tauu, senyum kamu tuu manisnyaa sempurnaa, akuu ga bosenn liatnyaa hihii❤️ ehh btw jangan lupaa posee siapp boss nyaa🫡HAHAHAA GEMEESSS",
            "harus di klik yaa",
            "center 20%"
        ));

        // --- FOTO KE-10 ---
        list.add(new MediaItem(10, "PHOTO", 
            "CIEE INII CERITANYAA KAMU LAGI OLAHRAGA YAKANN?", 
            "/assets/foto/cantik9.jpeg", 
            List.of("/assets/foto/cantik9.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu9.mp3", 
            "Short desc", 
            "setiap kalii aku liat fotoo kamu nii aku selalu ngebayanginn kita olahraga barengg hahahaa, lari tipis' gituu kan, pengen bangett huhuu:' apalagii ditemenin kamuu behh lari satu dunia pun sanggupp akuu, btw mundurr dikit ntann soalnya cantikk kamu kelewatann🤭 WKWKWKW",
            "ciee olahraga ni yee",
            "center"
        ));

        // --- FOTO KE-11 ---
        list.add(new MediaItem(11, "PHOTO", 
            "EEHHH ADAA BIDADARII LAGII FOTO MIRROR NII", 
            "/assets/foto/cantik10.jpeg", 
            List.of("/assets/foto/cantik10.jpeg", "/assets/foto/cantik10-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu26.mp3", 
            "Short desc", 
            "ntann kamu tauu gaa sii, setiap kali aku ngeliatt foto kamu pas lagi pap mirror nii tu kann, aku selalu ngebayanginn meluk kamu dari belakangg, pastii rasanya kek aocniubviqbqc (*saltingg bgtt nii ceritanyaa hahahaa) hhmm whenn yaa?",
            "kepoin dongg",
            "center"
        ));

        // --- FOTO KE-12 ---
        list.add(new MediaItem(12, "PHOTO", 
            "TADII BIDADARINYA LAGI PAP MIRROR, SEKARANGG PAP PAKE HELMM HIHII", 
            "/assets/foto/cantik11.jpeg", 
            List.of("/assets/foto/cantik11.jpeg", "/assets/foto/cantik11-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu6.mp3", 
            "Short desc", 
            "gatauu kenapa yaa, kalo aku ngeliatt pap kamuu yg gini tuu aku suka ngebayanginn hahaa, klo liat pap ini tuu aku ngebayanginn kalo kita motorann barengg terus kamu pake helm lucuu kya di pap kamuu, iii gaa kebayangg lucunyaa gimanaa",
            "penasaran ga isinya?",
            "center 15%"
        ));

        // --- FOTO KE-13 ---
        list.add(new MediaItem(13, "PHOTO", 
            "EEHHH SAMPE FOTO TANGAN KAMUU AKU SIMPEN WKWKWK", 
            "/assets/foto/cantik12.jpeg", 
            List.of("/assets/foto/cantik12.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu23.mp3", 
            "Short desc", 
            "HEEYYY INII TANGANN KAMUU BISAA DIGENGGAMM TERUSS GAA SIII? KALO KITA DEKEETT NII KAN AKUU GAMAU LEPASS GENGGAM TANGANN KAMUU HAHAHAA, I WISHH I WISHH...",
            "penasaran ga si isinya gimana?",
            "center 40%"
        ));

        // --- FOTO KE-14 ---
        list.add(new MediaItem(14, "PHOTO", 
            "WIII ADAA YG MANYUNN MANYUNN NICHH", 
            "/assets/foto/cantik13.jpeg", 
            List.of("/assets/foto/cantik13.jpeg", "/assets/foto/cantik13-2.jpeg", "/assets/foto/cantik13-3.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu3.mp3", 
            "Short desc", 
            "duuhh kamuu ini definisinya tuu manissnya dapett, lucunyaa dapett, cantikknyaa juga dapett bangett arrghhh, kalo bolee jujur pap kamuu ini pernah aku jadiin wallpaper hp aku tauu hahahaa lebih tepatnyaa pap yg posee peacee tuu soalnyaa lucu bangett😘✌️",
            "sumpah ini kamu cantikk bangett",
            "center 5%"
        ));

        // --- FOTO KE-15 ---
        list.add(new MediaItem(15, "PHOTO", 
            "APAAA LAGII NII KOK CANTIIK BANGETT?!", 
            "/assets/foto/cantik20.jpeg", 
            List.of("/assets/foto/cantik20.jpeg", "/assets/foto/cantik20-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu22.mp3", 
            "Short desc", 
            "kamuu tau gaa kenapa aku milih lagu a thousand years buat pap kamuu yg ini? karena tiap liatt pap kamu yg ini rasa untuk menunggu kamu tuu menggebu-gebuu, bahkan seribu tahun pun masii terasa singkat bagi aku kalau yg aku tunggu itu kamuu, tapii... kamu terlaluu perfe☪️✝️ gaa sii buat ditunggu? HAHAHHAA",
            "gemess bangett ini",
            "center 5%"
        ));

        // --- FOTO KE-16 ---
        list.add(new MediaItem(16, "PHOTO", 
            "EHH INII FILTER NYAA LUCUU BANGEETT", 
            "/assets/foto/cantik22.jpeg", 
            List.of("/assets/foto/cantik22.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu27.mp3", 
            "Short desc", 
            "aduuhh gemeess bangeett sii kamuu, kamu tau gaa kemaren aku pengenn jadiin pap kamu yg inii jadi pp di salah satuu akun aplikasi pemograman akuu supaya bisaa jadi penyemangatt akuu soalnya pap kamu ini gemees and cantikk bangettt aarrghhh, tapii aku mikir lagii nanti temenn' aku liat pap kamuu yg ini jadinya nanti aku cemburuu:( tapii beneran ini pap nyaa gemeess bangett, cocokk ihh filternyaa sama kamuu😗",
            "filternya lucuu hihii",
            "center 75%"
        ));

        // --- FOTO KE-17 ---
        list.add(new MediaItem(17, "PHOTO", 
            "DUHAAII INI POSENYAA CENTILL' GEMEESS", 
            "/assets/foto/cantik23.jpeg", 
            List.of("/assets/foto/cantik23.jpeg", "/assets/foto/cantik23-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu16.mp3", 
            "Short desc", 
            "HEYY HEEYYY ITUU KAMUNYAA CAANTIKK BANGEETT WOILAAA, MANA KAMUU POSEE CENTILL LAGIII MAKINN GAA KUATT AKUU NAHAN SALTINGG DAN SENENGNYAA ARRGGHHH😔, SESUAII LAGUNYAA SETIAP AKU LIATT PAP KAMU INI TUU VIBESNYAA KAMU TUU JADI SOSOKK YG HADIR UNTUK BUAT HARI HARII AKU JADII LEBIH INDAHH HIHII❤️❤️❤️",
            "liatt deh senyum kamuu tu bikin canduu",
            "center 10%"
        ));

        // --- FOTO KE-18 ---
        list.add(new MediaItem(18, "PHOTO", 
            "EIITSS ADAA YANG MANISS MANISS NICHH", 
            "/assets/foto/cantik16.jpeg", 
            List.of("/assets/foto/cantik16.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu12.mp3", 
            "Short desc", 
            "kalo bole jujur pap ini aku gaa suka, iya beneran ga suka, KARNAA KAMUU KEMARINN CUMAA NGIRIM PAP INII SATU DOANGG SEKALI LAGII SATUU DOAANGG! padahall kemarin kamu uda nunjukin pap ini sama ada juga pap yg lainn bahkan kamu nunjukin juga jj nyaa tapii sayang bangeett kamu nunjukinnya cuma sekali liat doang huhuu:' but its okaayy yg pentingg aku uda dapett pap cantiikk kamuu yg ini hihii❤️❤️ ehh btw yg aku bilang tadi ga suka ituu candaa doang yaa itu teknik ancaman ajaa hahahaa *manatau nanti kamu ngirim temen pap yg ini kan hehee",
            "klik dong biar ehem...",
            "center 10%"
        ));

        // --- FOTO KE-19 ---
        list.add(new MediaItem(19, "PHOTO", 
            "KALO YG DIATAS TADII POSE CENTIL' GEMESS, NAH YG INII POSE CENTILL YG CENTILNYA TUU CENTIILL BANGEETT", 
            "/assets/foto/cantik24.jpeg", 
            List.of("/assets/foto/cantik24.jpeg", "/assets/foto/cantik24-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu24.mp3", 
            "Short desc", 
            "ntann? toloongg bangett ini mahh kalo cantikk tuu bisa gaa jangan cantikk bangeett, nantii kalo banyak yg sukaa terus aku cemburu gimanaa dongg?🙁 HAHAHAAA CANDAA YAAA, ehh tapii beneran tauu pap kamuu ini caantikk dan centilnyaa tuu dapett bangeett, kalo lagunyaa bilang 'kau cantik hari ini' menurut aku itu gaa bener soalnyaa kamuu cantikk selamaa-lamanyaa khusunyaa di hatii akuu hihii❤️❤️❤️",
            "ini sii centilnya kelewatann",
            "center 10%"
        ));

        // --- FOTO KE-20 ---
        list.add(new MediaItem(20, "PHOTO", 
            "UTUTUTUUU CERITANYAA NII LAGI PAP ALAA' CEMBEYUUTT GITUU", 
            "/assets/foto/cantik25.jpeg", 
            List.of("/assets/foto/cantik25.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu2.mp3", 
            "Short desc", 
            "sayaangg? jangan cembeyutt gituu iihh nanti cantiknyaa ilangg loo, tapii boongg wlee orang di pap ini tuu kamuu cantikk iyaa, gemess juga iyaa hahahaa malahan kalo cembeyutt gini tuu makin cantikk tauu mmuuaahh, kalo kamu cembeyutt mau gaa aku kiss?😙",
            "cembeyutnyaa gemes ihh",
            "center"
        ));

        // --- FOTO KE-21 ---
        list.add(new MediaItem(21, "PHOTO", 
            "INI SII PAP RANDOM NYAA GEMEES BANGEETT", 
            "/assets/foto/cantik18.jpeg", 
            List.of("/assets/foto/cantik18.jpeg", "/assets/foto/cantik18-2.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu29.mp3", 
            "Short desc", 
            "kamu tau gaa sii ntann, pap random kamuu nii sering aku liatinn sebelum boboo pas di asramaa hahahaa, soalnyaa kalo ngeliat pap random kamuu nii aku jadii ngerasa ademm bangett pokoknyaa kek senengg campur tenangg campurr gemeess jugaa hahaa soalnyaa pap nyaa lucuu❤️❤️ next timee banyak'in pap randomm ginii yaa hehee soalnya aku candu liatnyaa, btw posee ngook nyaa dluu dongg HAHAHHAA",
            "ada bidadari lagi pap random",
            "center"
        ));

        // --- FOTO KE-22 ---
        list.add(new MediaItem(22, "PHOTO", 
            "M-MAAPP YAA AKU KEPOINN AKUN TIKTOK KAMUU", 
            "/assets/foto/cantik15.jpeg", 
            List.of("/assets/foto/cantik15.jpeg", "/assets/foto/cantik15-2.jpeg", "/assets/foto/cantik15-3.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu30.mp3", 
            "Short desc", 
            "ntaann, m-maapp yaa diam' aku ss pap kamuu yg ada di tiktok kamuu hahahaa, kamuu gausaa maluu yaaa, ini pap kamuu cantiikk bangett tauu, akuu takut pengen nyimpenn dari tiktonya langsungg soalnya takutt ketahuan sama kamuu makanyaa aku ss diamm' hehee",
            "kepoinn dong",
            "center 10%"
        ));

        // --- FOTO KE-23 ---
        list.add(new MediaItem(23, "PHOTO", 
            "SELAINN TIKTOK AKU JUGAA SERING KEPOINN IG HAHAHAA", 
            "/assets/foto/cantik21.jpeg", 
            List.of("/assets/foto/cantik21.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu21.mp3", 
            "Short desc", 
            "inii ceritanyaa kemaren aku liatt ig kamu kann terus aku liatt nii ada pp cantikk, tanpa rasa raguu dan penuh keberaniann serta rasa senangg langsung akuu ss dehh hahahaa, maapp yaa akunyaa random bangett wkwkwk",
            "hehehee",
            "center 68%"
        ));

        // --- FOTO KE-24 ---
        list.add(new MediaItem(24, "PHOTO", 
            "GAA HANYAA PP IG, AKUU JUGA SERIINGG KEPOINN SG KAMUU HIHII", 
            "/assets/foto/cantik19.jpeg", 
            List.of("/assets/foto/cantik19.jpeg", "/assets/foto/cantik19-2.jpeg", "/assets/foto/cantik19-3.jpeg", "/assets/foto/cantik19-4.jpeg", "/assets/foto/cantik19-5.jpeg", "/assets/foto/cantik19-6.jpeg", "/assets/foto/cantik19-7.jpeg", "/assets/foto/cantik19-8.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu18.mp3", 
            "Short desc", 
            "NTAANNN JANGANN MARAAHH YAAA PWIISSS... ini aku nyimpenn beberapaa sg kamuu dari kemarenn' hahahaa, salah kamuu sii kamunyaa cantikk makanyaa setiap sg yg ada kamunyaa aku ss teruss aku simpenn bahkan aku buat albumnyaa, sumpah demi apapunn kamuu emang secantiikk itu tauu, gaa hanyaa cantikk kamu juga maniss, lucuu, gemess, ada centill' nya jugaa pokoknyaa tuu kamuu tipee aku bangett, ituu ss sg kamuu yg aku simpenn cantiik semuaa gada yg gagall dan gadaa yg boseninn, semuanyaa buat akuu jadi tercandu canduu hihii❤️❤️❤️",
            "ini sg kamu banyak banget yg aku simpen..",
            "center 12%"
        ));

        // --- FOTO KE-25 ---
        list.add(new MediaItem(25, "PHOTO", 
            "BAHKANN SG KAMUU YG HANYAA LIATIN OUTFIT AJAA AKU SIMPENN", 
            "/assets/foto/cantik17.jpeg", 
            List.of("/assets/foto/cantik17.jpeg"), 
            Collections.emptyList(), 
            "/assets/musik/lagu31.mp3", 
            "Short desc", 
            "ntaann, ini aku udaa gilaa ga sii? wkwkw, sangking tercandu candunyaa aku sama kamuu sg kamu yg nampilin outfit aja sampe aku simpenn wkwkw, waktuu liat sg nii tuu aku langsung bayanginn kitanya jalan couplean pake clean outfitt kya di sg kamu tuu, kenapa yaa setiap tentang kamu aku selalu ngebayanginn, apakah ini efek kecintaann? HAHAHAA",
            "ini sii ceritanya outfit check yaa",
            "center 80%"
        ));

        // ... (Kode Video 26 s.d 28 biarkan saja di bawah) ...

        // ======================= VIDEO (26-28) =======================

        // Video 1
        list.add(new MediaItem(26, "VIDEO", "SELAINN SUKA NYIMPENN SG FOTO DIAM' AKU JUGA SUKAA NYIMPENN SG KAMU YG ADA JJ NYAA", "/assets/video/vid1.jpeg", 
            Collections.emptyList(), List.of("/assets/video/vid1.mp4", "/assets/video/vid1-2.mp4", "/assets/video/vid1-3.mp4", "/assets/video/vid1-4.mp4", "/assets/video/vid1-5.mp4"), null, "Short desc", 
            "hehehee maapp yaa lagi' akuu nyimpenn sg kamu diemm' tapi kali ini tentang per jj an hahahaa, jadii video pertamaa tuu aku diemm' record dan simpen sg kamu yg jj hehehe, gaa hanya itu aku juga diem' record dan simpen sg kamu juga yg ada jj nyaa, teruss aku juga gaa hanya simpen sg yg ada jj nyaa loo, aku jugaa simpenn video jj yg kamu kirim kemaren', entah kenapaa aku gaperna bosenn muter jj kamu inii, gaa hanya karna cantikk tapi karna kerenn jugaa apalagii yg aku mau kess ituu HAHAHAA, pokoknyaa semuanyaa gemeeesss, akuu sukaa pakee BANGEEETTT❤️❤️❤️",
            "kepo kan sama jj yg aku simpen apa aja? hahhaa",
            "center 40%"
        ));

        // Video 2
        list.add(new MediaItem(27, "VIDEO", "EIITSSS INI VIDEOO APAA YAA? HAHAHAA", "/assets/video/vid2.jpeg", 
            Collections.emptyList(), List.of("/assets/video/vid2.mp4", "/assets/video/vid2-1.mp4"), null, "Short desc", 
            "aku masii ingett bangett, dua videoo itu kamu kirimm tepat setelah kita sempet berantemm karna ehemm (yg kamu upload tentang si itu) nah pokoknyaa ituu laa yakann, waktuu itu akuu senengg bangeett kamu ngirimin aku videoo hihii mana kamu cantiikk bangett lagi di video ituu, sangking senengnyaa aku langsungg save videonyaa dan aku buat ke album di galerii aku biar bisa aku liat teruss, duaa videonyaa gemeess bangett, akuu sukaa dan demenn liatin videonyaa hihii❤️❤️",
            "ini isinya video kamu yg sangat amat cantikk",
            "center 30%"
        ));

        // Video 3
        list.add(new MediaItem(28, "VIDEO", "INII AKU NYIMPENN SG KAMU DIAMM' PART 182409040607 HAHAHAA", "/assets/video/vid3.jpeg", 
            Collections.emptyList(), List.of("/assets/video/vid3.mp4", "/assets/video/vid3-2.mp4"), null, "Short desc", 
            "hehehee maklumin yaa ntann, akuu uda kecintaan bangett sama kamuu, makanyaa aku gamauu ketinggalan sedikitt pun tentang kamuu, dua video ituu dua duanyaa aku simpen diem' waktu kamu buat sg kemarenn hehee, yg diataas tuu aku liat vibesnyaa kya kakak' jaksell yaa soalnyaa cantiikk and elegann gituu, kalo videoo kedua tuu gaperluu ditanyaa lagii laa uda pastii videonya gemess dan lucuu bangett, gemess dan lucuu kenapa tuu? karnaa... ikan hiuu melayangg' i lovee u sayaangg❤️❤️ HAHAHAAA mmuuaahh",
            "ciee kepo yaa?",
            "center 46.5%"
        ));

        return list;
    }

    // ========================================================
    // LOGIKA CONTROLLER (TETAP SAMA SEPERTI SEBELUMNYA)
    // ========================================================

    @GetMapping("/")
    public String index(HttpSession session) {
        return "pages/gate1";
    }

    // LOGIKA VALIDASI GATE 1 (Diupdate untuk Animasi Success)
    @PostMapping("/check-gate1")
    public String checkGate1(@RequestParam("day") String day, 
                             @RequestParam("month") String month, 
                             @RequestParam("year") String year,
                             HttpSession session, 
                             Model model, // Tambah Model
                             RedirectAttributes redirectAttributes) {
        
        // Cek apakah input SESUAI PERCIS dengan 24 April 2007
        boolean isDateCorrect = "24".equals(day) && 
                                "April".equalsIgnoreCase(month) && 
                                "2007".equals(year);

        if (isDateCorrect) {
            // JIKA BENAR:
            // 1. Simpan tanda lolos di session
            session.setAttribute("GATE1_PASSED", true);
            
            // 2. Jangan redirect dulu, kirim sinyal 'success' ke HTML biar muncul animasi
            model.addAttribute("success", true); 
            return "pages/gate1"; 
        } else {
            // JIKA SALAH:
            // Kirim pesan error baru sesuai request
            redirectAttributes.addFlashAttribute("error", "iss tanggal lahir kamu bukan itu, isi lagi ya sayang");
            return "redirect:/";
        }
    }

    @GetMapping("/gate2")
    public String gate2(HttpSession session) {
        if (session.getAttribute("GATE1_PASSED") == null) return "redirect:/";
        return "pages/gate2";
    }

    // LOGIKA VALIDASI GATE 2 (Diupdate untuk Animasi Success)
    @PostMapping("/check-gate2")
    public String checkGate2(@RequestParam("day") String day, 
                             @RequestParam("month") String month, 
                             @RequestParam("year") String year,
                             HttpSession session, 
                             Model model, // Tambah Model
                             RedirectAttributes redirectAttributes) {
        
        // Cek Session Gate 1 (Security)
        if (session.getAttribute("GATE1_PASSED") == null) return "redirect:/";

        // Cek Validasi Tanggal (18 September 2006)
        boolean isDateCorrect = "18".equals(day) && 
                                "September".equalsIgnoreCase(month) && 
                                "2006".equals(year);

        if (isDateCorrect) {
            // JIKA BENAR:
            session.setAttribute("GATE2_PASSED", true);
            
            // Kirim sinyal success ke HTML biar animasi muncul dulu
            model.addAttribute("success", true);
            return "pages/gate2"; 
        } else {
            // JIKA SALAH:
            redirectAttributes.addFlashAttribute("error", "yahh masa kamu lupa sii huhuu sedihnyaa:' isi lagi yaa sayang");
            return "redirect:/gate2";
        }
    }

    @GetMapping("/gallery")
    public String gallery(HttpSession session, Model model) {
        if (session.getAttribute("GATE2_PASSED") == null) return "redirect:/gate2";
        model.addAttribute("mediaList", getMediaList());
        return "pages/gallery";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, HttpSession session, Model model) {
        if (session.getAttribute("GATE2_PASSED") == null) return "redirect:/gate2";

        List<MediaItem> list = getMediaList();
        MediaItem selectedItem = list.stream()
                .filter(item -> item.id == id)
                .findFirst()
                .orElse(null);

        if (selectedItem == null) return "redirect:/gallery";

        model.addAttribute("item", selectedItem);
        return "pages/detail";
    }
}