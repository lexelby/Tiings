package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_05c
   extends TilingType
{
   public TilingTypeN6_05c(){
      super( "N6-5c", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{360,180,100};
      paramDef = new int[]{150, 75, 45};
      paramName = new String[]{ "Angle 1", "Angle 2", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,0,1, 1},
            {2, 0,1, 1,4,5, 0},
            {0, 2,1, 2,4,5, 0},
            {1, 1,2, 3,0,1, 1},
            {2, 0,1, 4,4,5, 0},
      };
      info = "a=d\nb=c=f\nA=C\nC+D+E=360\n(A+B+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = getParam(paramValues,2)/100.;
      double ln2 = 1 - ln1;
      double an = 90-paramValues[0]/2.;
      double dx1 = ln1 * Math.cos( an * DEG2RAD);
      double dy1 = ln1 * Math.sin( an * DEG2RAD);
      double dx2 = ln2 * Math.cos(paramValues[1] * DEG2RAD);
      double dy2 = ln2 * Math.sin(paramValues[1] * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, dx1, -dy1);
      baseTile.setPoint(2, 2*dx1, 0);
      baseTile.setPoint(3, 2*dx1-dx2, dy2);
      baseTile.setPoint(4, dx2+dx1, dy2+dy1);
      baseTile.setPoint(5, dx2, dy2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(3)-tiles[1].getX(0);
      offsets[1] = tiles[5].getY(3)-tiles[1].getY(0);
      offsets[2] = tiles[3].getX(5)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(5)-tiles[0].getY(0);
   }
}