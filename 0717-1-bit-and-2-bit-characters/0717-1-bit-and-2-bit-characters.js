/**
 * @param {number[]} bits
 * @return {boolean}
 */
var isOneBitCharacter = function (bits) {
    let len = bits.length;
    let count = 0;
    while (count < len - 1) {
        if (bits[count] === 1) {
            count += 2;
        } else {
            count += 1;
        }
    }

    return count === len - 1;
};