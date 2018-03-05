// This provides the frozen (compiled bytecode) files that are included if
// any.
#include <Python.h>

#include "nuitka/constants_blob.h"

// Blob from which modules are unstreamed.
#define stream_data constant_bin

// These modules should be loaded as bytecode. They may e.g. have to be loadable
// during "Py_Initialize" already, or for irrelevance, they are only included
// in this un-optimized form. These are not compiled by Nuitka, and therefore
// are not accelerated at all, merely bundled with the binary or module, so
// that CPython library can start out finding them.

struct frozen_desc {
    char const *name;
    ssize_t start;
    int size;
};

void copyFrozenModulesTo( struct _frozen *destination )
{
    struct frozen_desc frozen_modules[] = {
        { "_bootlocale", 6118457, 965 },
        { "_collections_abc", 6119422, 28828 },
        { "_compression", 6148250, 4089 },
        { "_weakrefset", 6152339, 7813 },
        { "abc", 6160152, 7473 },
        { "ast", 6167625, 11689 },
        { "base64", 6179314, 17120 },
        { "bz2", 6196434, 11267 },
        { "codecs", 6207701, 33885 },
        { "collections", 6241586, -45801 },
        { "collections.abc", 6119422, 28828 },
        { "copyreg", 6287387, 4229 },
        { "dis", 6291616, 14166 },
        { "encodings", 6305782, -3915 },
        { "encodings.aliases", 6309697, 6259 },
        { "encodings.ascii", 6315956, 1847 },
        { "encodings.base64_codec", 6317803, 2386 },
        { "encodings.big5", 6320189, 1407 },
        { "encodings.big5hkscs", 6321596, 1417 },
        { "encodings.bz2_codec", 6323013, 3248 },
        { "encodings.charmap", 6326261, 2900 },
        { "encodings.cp037", 6329161, 2392 },
        { "encodings.cp1006", 6331553, 2468 },
        { "encodings.cp1026", 6334021, 2396 },
        { "encodings.cp1125", 6336417, 8089 },
        { "encodings.cp1140", 6344506, 2382 },
        { "encodings.cp1250", 6346888, 2419 },
        { "encodings.cp1251", 6349307, 2416 },
        { "encodings.cp1252", 6351723, 2419 },
        { "encodings.cp1253", 6354142, 2432 },
        { "encodings.cp1254", 6356574, 2421 },
        { "encodings.cp1255", 6358995, 2440 },
        { "encodings.cp1256", 6361435, 2418 },
        { "encodings.cp1257", 6363853, 2426 },
        { "encodings.cp1258", 6366279, 2424 },
        { "encodings.cp273", 6368703, 2378 },
        { "encodings.cp424", 6371081, 2422 },
        { "encodings.cp437", 6373503, 7806 },
        { "encodings.cp500", 6381309, 2392 },
        { "encodings.cp65001", 6383701, 1646 },
        { "encodings.cp720", 6385347, 2489 },
        { "encodings.cp737", 6387836, 8128 },
        { "encodings.cp775", 6395964, 7836 },
        { "encodings.cp850", 6403800, 7467 },
        { "encodings.cp852", 6411267, 7844 },
        { "encodings.cp855", 6419111, 8097 },
        { "encodings.cp856", 6427208, 2454 },
        { "encodings.cp857", 6429662, 7449 },
        { "encodings.cp858", 6437111, 7437 },
        { "encodings.cp860", 6444548, 7785 },
        { "encodings.cp861", 6452333, 7800 },
        { "encodings.cp862", 6460133, 7989 },
        { "encodings.cp863", 6468122, 7800 },
        { "encodings.cp864", 6475922, 7946 },
        { "encodings.cp865", 6483868, 7800 },
        { "encodings.cp866", 6491668, 8133 },
        { "encodings.cp869", 6499801, 7826 },
        { "encodings.cp874", 6507627, 2520 },
        { "encodings.cp875", 6510147, 2389 },
        { "encodings.cp932", 6512536, 1409 },
        { "encodings.cp949", 6513945, 1409 },
        { "encodings.cp950", 6515354, 1409 },
        { "encodings.euc_jis_2004", 6516763, 1423 },
        { "encodings.euc_jisx0213", 6518186, 1423 },
        { "encodings.euc_jp", 6519609, 1411 },
        { "encodings.euc_kr", 6521020, 1411 },
        { "encodings.gb18030", 6522431, 1413 },
        { "encodings.gb2312", 6523844, 1411 },
        { "encodings.gbk", 6525255, 1405 },
        { "encodings.hex_codec", 6526660, 2373 },
        { "encodings.hp_roman8", 6529033, 2593 },
        { "encodings.hz", 6531626, 1403 },
        { "encodings.idna", 6533029, 5750 },
        { "encodings.iso2022_jp", 6538779, 1424 },
        { "encodings.iso2022_jp_1", 6540203, 1428 },
        { "encodings.iso2022_jp_2", 6541631, 1428 },
        { "encodings.iso2022_jp_2004", 6543059, 1434 },
        { "encodings.iso2022_jp_3", 6544493, 1428 },
        { "encodings.iso2022_jp_ext", 6545921, 1432 },
        { "encodings.iso2022_kr", 6547353, 1424 },
        { "encodings.iso8859_1", 6548777, 2391 },
        { "encodings.iso8859_10", 6551168, 2396 },
        { "encodings.iso8859_11", 6553564, 2490 },
        { "encodings.iso8859_13", 6556054, 2399 },
        { "encodings.iso8859_14", 6558453, 2417 },
        { "encodings.iso8859_15", 6560870, 2396 },
        { "encodings.iso8859_16", 6563266, 2398 },
        { "encodings.iso8859_2", 6565664, 2391 },
        { "encodings.iso8859_3", 6568055, 2398 },
        { "encodings.iso8859_4", 6570453, 2391 },
        { "encodings.iso8859_5", 6572844, 2392 },
        { "encodings.iso8859_6", 6575236, 2436 },
        { "encodings.iso8859_7", 6577672, 2399 },
        { "encodings.iso8859_8", 6580071, 2430 },
        { "encodings.iso8859_9", 6582501, 2391 },
        { "encodings.johab", 6584892, 1409 },
        { "encodings.koi8_r", 6586301, 2443 },
        { "encodings.koi8_t", 6588744, 2354 },
        { "encodings.koi8_u", 6591098, 2429 },
        { "encodings.kz1048", 6593527, 2406 },
        { "encodings.latin_1", 6595933, 1859 },
        { "encodings.mac_arabic", 6597792, 7700 },
        { "encodings.mac_centeuro", 6605492, 2430 },
        { "encodings.mac_croatian", 6607922, 2438 },
        { "encodings.mac_cyrillic", 6610360, 2428 },
        { "encodings.mac_farsi", 6612788, 2372 },
        { "encodings.mac_greek", 6615160, 2412 },
        { "encodings.mac_iceland", 6617572, 2431 },
        { "encodings.mac_latin2", 6620003, 2572 },
        { "encodings.mac_roman", 6622575, 2429 },
        { "encodings.mac_romanian", 6625004, 2439 },
        { "encodings.mac_turkish", 6627443, 2432 },
        { "encodings.mbcs", 6629875, 1658 },
        { "encodings.oem", 6631533, 1471 },
        { "encodings.palmos", 6633004, 2419 },
        { "encodings.ptcp154", 6635423, 2513 },
        { "encodings.punycode", 6637936, 6430 },
        { "encodings.quopri_codec", 6644366, 2406 },
        { "encodings.raw_unicode_escape", 6646772, 1732 },
        { "encodings.rot_13", 6648504, 2964 },
        { "encodings.shift_jis", 6651468, 1417 },
        { "encodings.shift_jis_2004", 6652885, 1427 },
        { "encodings.shift_jisx0213", 6654312, 1427 },
        { "encodings.tis_620", 6655739, 2481 },
        { "encodings.undefined", 6658220, 2126 },
        { "encodings.unicode_escape", 6660346, 1712 },
        { "encodings.unicode_internal", 6662058, 1722 },
        { "encodings.utf_16", 6663780, 4796 },
        { "encodings.utf_16_be", 6668576, 1597 },
        { "encodings.utf_16_le", 6670173, 1597 },
        { "encodings.utf_32", 6671770, 4689 },
        { "encodings.utf_32_be", 6676459, 1490 },
        { "encodings.utf_32_le", 6677949, 1490 },
        { "encodings.utf_7", 6679439, 1518 },
        { "encodings.utf_8", 6680957, 1577 },
        { "encodings.utf_8_sig", 6682534, 4494 },
        { "encodings.uu_codec", 6687028, 3190 },
        { "encodings.zlib_codec", 6690218, 3086 },
        { "enum", 6693304, 23396 },
        { "functools", 6716700, 23912 },
        { "genericpath", 6740612, 3711 },
        { "heapq", 6744323, 14277 },
        { "importlib", 6758600, -3585 },
        { "importlib._bootstrap", 6762185, 29099 },
        { "importlib._bootstrap_external", 6791284, 38886 },
        { "importlib.machinery", 6830170, 935 },
        { "inspect", 6831105, 79014 },
        { "io", 6910119, 3372 },
        { "keyword", 6913491, 1750 },
        { "linecache", 6915241, 3763 },
        { "locale", 6919004, 33000 },
        { "ntpath", 6952004, 13650 },
        { "opcode", 6965654, 5398 },
        { "operator", 6971052, 13898 },
        { "os", 6984950, 29613 },
        { "quopri", 7014563, 5758 },
        { "re", 7020321, 14043 },
        { "reprlib", 7034364, 5385 },
        { "sre_compile", 7039749, 10263 },
        { "sre_constants", 7050012, 5957 },
        { "sre_parse", 7055969, 20343 },
        { "stat", 7076312, 3836 },
        { "stringprep", 7080148, 10015 },
        { "struct", 7090163, 297 },
        { "threading", 7090460, 37226 },
        { "token", 7127686, 3305 },
        { "tokenize", 7130991, 18528 },
        { "traceback", 7149519, 19521 },
        { "types", 7169040, 8186 },
        { "warnings", 7177226, 13243 },
        { "weakref", 7190469, 19128 },
        { NULL, 0, 0 }
    };

    struct frozen_desc *current = frozen_modules;

    for(;;)
    {
        destination->name = (char *)current->name;
        destination->code = (unsigned char *)&constant_bin[ current->start ];
        destination->size = current->size;

        if (destination->name == NULL) break;

        current += 1;
        destination += 1;
    };
}