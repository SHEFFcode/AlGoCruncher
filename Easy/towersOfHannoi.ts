function moveBlock(numberOfBlocks: number, from: string, to: string, using: string): void {
  if (numberOfBlocks === 1) {
    console.log(`Moving block ${numberOfBlocks} from ${from} to ${to}`);
  }
  moveBlock(numberOfBlocks - 1, from, using, to);
  console.log(`Moving block ${numberOfBlocks} from ${from} to ${to}`);
  moveBlock(numberOfBlocks - 1, using, to, from);
}

moveBlock(1, 'a', 'c', 'b');