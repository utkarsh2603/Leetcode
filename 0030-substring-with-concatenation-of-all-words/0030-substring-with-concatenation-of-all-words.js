var findSubstring = function (s, words) {
    let wordLen = words[0].length
    let totalWords = words.length
    let subStrLen = wordLen * totalWords

    let cache = {}
    function checkString(str) {
        if (str in cache) {
            return cache[str]
        }
        let tempWords = [...words]
        for (let i = 0; i < totalWords; i++) {
            let w = str.slice(i * wordLen, (i + 1) * wordLen)
            let index = tempWords.indexOf(w)
            if (index >= 0) {
                tempWords[index] = null
            } else {
                cache[str] = false
                return cache[str]
            }
        }
        cache[str] = true
        return cache[str]
    }

    let result = []
    let maxIndex = (s.length - subStrLen)
    for (let i = 0; i <= maxIndex; i++) {
        let subStr = s.slice(i, subStrLen + i)
        if (checkString(subStr)) {
            result.push(i)
        }
    }
    return result
};