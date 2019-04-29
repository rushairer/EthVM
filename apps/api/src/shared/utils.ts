/**
 * Applies Object.assign but not for any fields which are null or undefined. This helps
 * with postgres. Any attempts to nullify a field in the database should be explicity via some
 * kind of mutation function etc.
 *
 * @param target
 * @param source
 */
export function assignClean(target: any, source: any) {
  const sourceCopy = { ...source }

  for (const key of Object.keys(sourceCopy)) {
    const value = sourceCopy[key]
    if (value === null || value === undefined) {
      delete sourceCopy[key]
    }
  }

  return Object.assign(target, sourceCopy)
}

/**
 * Determines if a Buffer is a GZIP file
 * modified from https://github.com/kevva/is-gzip
 * @param buffer
 */
export function isGzip(buffer: Buffer): boolean {
  if (!buffer || buffer.length < 3) {
    return false;
  }

  return buffer[0] === 0x1F && buffer[1] === 0x8B && buffer[2] === 0x08;
}
