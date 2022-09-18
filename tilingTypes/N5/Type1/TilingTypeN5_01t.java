package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01t
   extends TilingType
{
   public TilingTypeN5_01t(){
      super( "N5-1t", 5, SymmetryType.pg );

      paramMin = new int[]{-45};
      paramMax = new int[]{ 79};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 1,2, 0,4,0, 1},
            {1, 0,1, 2,0,1, 0},
            };
      info = "a=c=d=e\nA+B=180\nC=2B\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .5;
      double f = paramValues[0];

      double b = 120-f/3;
      double ln2 = 2 *ln1* Math.cos( f * DEG2RAD); // long side

      double x4 = ln1*Math.cos( (b) * DEG2RAD);
      double y4 = ln1*Math.sin( (b) * DEG2RAD);
      double x2 = x4+ln2;
      double y2 = y4;
      double x3 = x2 -ln1* Math.cos( f * DEG2RAD);
      double y3 = y2 +ln1* Math.sin( f * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(4);
      offsets[2] = tiles[0].getX(4)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[1].getY(3);
   }
}
