function moveBlock(numberOfBlocks, from, to, using) {
    if (numberOfBlocks === 1) {
        console.log("Moving block " + numberOfBlocks + " from " + from + " to " + to);
    }
    moveBlock(numberOfBlocks - 1, from, using, to);
    console.log("Moving block " + numberOfBlocks + " from " + from + " to " + to);
    moveBlock(numberOfBlocks - 1, using, to, from);
}
moveBlock(1, 'a', 'c', 'b');
