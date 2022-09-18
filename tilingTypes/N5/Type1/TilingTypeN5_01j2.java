package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01j2
   extends TilingType
{
   public TilingTypeN5_01j2(){
      super( "N5-1j2: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{ 45};
      paramMax = new int[]{120};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,2,3, 1},
            {1, 2,1, 0,3,4, 0},
            {0, 2,3, 2,3,4, 1},
            
            {0, 1,0, 3,0,1, 1},
            {1, 3,4, 4,2,3, 0},
            {1, 4,0, 5,2,3, 1},
            {0, 2,3, 6,3,4, 0},            
      };
      info = "a=c=d=e\nA+B=180\nA=E\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double f = paramValues[0];
      double c1 = ln*Math.cos( f * DEG2RAD);
      double s1 = ln*Math.sin( f * DEG2RAD);
      double c2 = ln*Math.cos( (f+f) * DEG2RAD);
      double s2 = ln*Math.sin( (f+f) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,-c2-c2,  0);
      baseTile.setPoint(2,-c1-c2-c2, s1);
      baseTile.setPoint(3,-c1-c2, s1+s2);
      baseTile.setPoint(4,-c1, s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[2].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[2].getY(0);
   }
}
